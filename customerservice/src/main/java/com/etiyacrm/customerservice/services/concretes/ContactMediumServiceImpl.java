package com.etiyacrm.customerservice.services.concretes;

import com.etiyacrm.customerservice.entities.City;
import com.etiyacrm.customerservice.entities.ContactMedium;
import com.etiyacrm.customerservice.entities.Customer;
import com.etiyacrm.customerservice.entities.IndividualCustomer;
import com.etiyacrm.customerservice.repositories.ContactMediumRepository;
import com.etiyacrm.customerservice.services.abstracts.ContactMediumService;
import com.etiyacrm.customerservice.services.dtos.requests.contactMedium.CreateContactMediumRequest;
import com.etiyacrm.customerservice.services.dtos.requests.contactMedium.UpdateContactMediumRequest;
import com.etiyacrm.customerservice.services.dtos.responses.contactMedium.CreatedContactMediumResponse;
import com.etiyacrm.customerservice.services.dtos.responses.contactMedium.DeletedContactMediumResponse;
import com.etiyacrm.customerservice.services.dtos.responses.contactMedium.GetContactMediumResponse;
import com.etiyacrm.customerservice.services.dtos.responses.contactMedium.UpdatedContactMediumResponse;
import com.etiyacrm.customerservice.services.mappers.ContactMediumMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class ContactMediumServiceImpl implements ContactMediumService {
    private ContactMediumRepository contactMediumRepository;

    @Override
    public CreatedContactMediumResponse add(CreateContactMediumRequest createContactMediumRequest) {

        ContactMedium contactMedium = ContactMediumMapper.INSTANCE.contactMediumFromCreateContactMediumRequest(createContactMediumRequest);

        ContactMedium createdContactMedium = contactMediumRepository.save(contactMedium);
        CreatedContactMediumResponse createdContactMediumResponse = ContactMediumMapper.INSTANCE.createdContactMediumResponseFromContactMedium(createdContactMedium);
        createdContactMediumResponse.setCustomerId(createContactMediumRequest.getCustomerId());
        return createdContactMediumResponse;
    }

    @Override
    public UpdatedContactMediumResponse update(long id, UpdateContactMediumRequest updateContactMediumRequest) {
        Customer customer = new Customer();
        customer.setId(id);

        ContactMedium contactMedium = ContactMediumMapper.INSTANCE.contactMediumFromUpdateContactMediumRequest(updateContactMediumRequest);
        contactMedium.setId(id);
        contactMedium.setCustomer(customer);
        contactMedium.setUpdatedDate(LocalDateTime.now());
        ContactMedium updatedContactmedium = contactMediumRepository.save(contactMedium);

        UpdatedContactMediumResponse updatedContactMediumResponse = ContactMediumMapper.INSTANCE.updatedContactMediumResponseFromContactMedium(updatedContactmedium);
        return updatedContactMediumResponse;
    }

    @Override
    public GetContactMediumResponse getById(long id) {
        ContactMedium contactMedium = contactMediumRepository.findById(id).get();
        GetContactMediumResponse contactMediumResponse = ContactMediumMapper.INSTANCE.getContactMediumResponseFromContactMedium(contactMedium);
        return contactMediumResponse;
    }

    @Override
    public DeletedContactMediumResponse delete(long id) {
        ContactMedium contactMedium = contactMediumRepository.findById(id).get();
        contactMedium.setId(id);
        contactMedium.setDeletedDate(LocalDateTime.now());
        ContactMedium deletedContactMedium = contactMediumRepository.save(contactMedium);

        DeletedContactMediumResponse deletedContactMediumResponse = ContactMediumMapper.INSTANCE.deletedContactMediumResponseFromContactMedium(deletedContactMedium);
        deletedContactMediumResponse.setDeletedDate(deletedContactMedium.getDeletedDate());
        return deletedContactMediumResponse;
    }
}