package com.etiyacrm.customerservice.services.concretes;

import com.etiyacrm.common.events.customers.CustomerCreatedEvent;

import com.etiyacrm.common.exceptions.types.BusinessException;
import com.etiyacrm.customerservice.entities.City;
import com.etiyacrm.customerservice.entities.ContactMedium;
import com.etiyacrm.customerservice.entities.Customer;
import com.etiyacrm.customerservice.entities.IndividualCustomer;
import com.etiyacrm.customerservice.kafka.producers.CustomerProducer;
import com.etiyacrm.customerservice.repositories.ContactMediumRepository;
import com.etiyacrm.customerservice.services.abstracts.ContactMediumService;
import com.etiyacrm.customerservice.services.abstracts.CustomerService;
import com.etiyacrm.customerservice.services.abstracts.IndividualCustomerService;
import com.etiyacrm.customerservice.services.dtos.requests.contactMedium.CreateContactMediumRequest;
import com.etiyacrm.customerservice.services.dtos.requests.contactMedium.UpdateContactMediumRequest;
import com.etiyacrm.customerservice.services.dtos.responses.contactMedium.CreatedContactMediumResponse;
import com.etiyacrm.customerservice.services.dtos.responses.contactMedium.DeletedContactMediumResponse;
import com.etiyacrm.customerservice.services.dtos.responses.contactMedium.GetContactMediumResponse;
import com.etiyacrm.customerservice.services.dtos.responses.contactMedium.UpdatedContactMediumResponse;
import com.etiyacrm.customerservice.services.mappers.ContactMediumMapper;
import com.etiyacrm.customerservice.services.rules.ContactMediumBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class ContactMediumServiceImpl implements ContactMediumService {
    private ContactMediumRepository contactMediumRepository;
    private CustomerService customerService;
    private CustomerProducer customerProducer;
    private IndividualCustomerService individualCustomerService;
    private ContactMediumBusinessRules contactMediumBusinessRules;

    @Override
    public CreatedContactMediumResponse add(CreateContactMediumRequest createContactMediumRequest) {

        ContactMedium contactMedium = ContactMediumMapper.INSTANCE.contactMediumFromCreateContactMediumRequest(createContactMediumRequest);
        Customer customer = customerService.findById(createContactMediumRequest.getCustomerId());
        contactMedium.setCustomer(customer);
        ContactMedium createdContactMedium = contactMediumRepository.save(contactMedium);
        CreatedContactMediumResponse createdContactMediumResponse = ContactMediumMapper.INSTANCE.createdContactMediumResponseFromContactMedium(createdContactMedium);

//        IndividualCustomer individualCustomer = individualCustomerService.findById(customer.getId());
//
//
//        CustomerCreatedEvent customerCreatedEvent = new CustomerCreatedEvent(
//                createdContactMediumResponse
//                createdIndividualCustomerResponse.getFirstName(),
//                createdIndividualCustomerResponse.getMiddleName(),
//                createdIndividualCustomerResponse.getLastName(),
//                createdIndividualCustomerResponse.getFatherName(),
//                createdIndividualCustomerResponse.getNationalityIdentity()
//        );
//        customerProducer.sendMessage(customerCreatedEvent);
        return createdContactMediumResponse;
    }

    @Override
    public UpdatedContactMediumResponse update(long id, UpdateContactMediumRequest updateContactMediumRequest) {


        ContactMedium getContactMediumById = findById(id);
        ContactMedium contactMedium = ContactMediumMapper.INSTANCE.contactMediumFromUpdateContactMediumRequest(updateContactMediumRequest);
        contactMedium.setId(id);
        contactMedium.setCreatedDate(getContactMediumById.getCreatedDate());
        contactMedium.setUpdatedDate(LocalDateTime.now());

        Customer customer = customerService.findById(getContactMediumById.getCustomer().getId());
        contactMedium.setCustomer(customer);
        ContactMedium updatedContactmedium = contactMediumRepository.save(contactMedium);

        UpdatedContactMediumResponse updatedContactMediumResponse = ContactMediumMapper.INSTANCE.updatedContactMediumResponseFromContactMedium(updatedContactmedium);
        return updatedContactMediumResponse;
    }

    @Override
    public GetContactMediumResponse getById(long id) {
        contactMediumBusinessRules.contactMediumIdIsExist(id);
        ContactMedium contactMedium = contactMediumRepository.findById(id).get();
        GetContactMediumResponse contactMediumResponse = ContactMediumMapper.INSTANCE.getContactMediumResponseFromContactMedium(contactMedium);
        return contactMediumResponse;
    }

    @Override
    public DeletedContactMediumResponse delete(long id) {
        contactMediumBusinessRules.contactMediumIdIsExist(id);
        ContactMedium contactMedium = contactMediumRepository.findById(id).get();
        contactMedium.setId(id);
        contactMedium.setDeletedDate(LocalDateTime.now());
        ContactMedium deletedContactMedium = contactMediumRepository.save(contactMedium);

        DeletedContactMediumResponse deletedContactMediumResponse = ContactMediumMapper.INSTANCE.deletedContactMediumResponseFromContactMedium(deletedContactMedium);
        deletedContactMediumResponse.setDeletedDate(deletedContactMedium.getDeletedDate());
        return deletedContactMediumResponse;
    }

    @Override
    public ContactMedium findById(long id) {
        return contactMediumRepository.findById(id).orElseThrow(() -> new BusinessException("City not found"));
    }
}