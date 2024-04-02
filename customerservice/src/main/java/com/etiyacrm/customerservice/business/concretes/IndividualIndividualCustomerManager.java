package com.etiyacrm.customerservice.business.concretes;

import com.etiyacrm.customerservice.business.abstracts.IndividualCustomerService;
import com.etiyacrm.customerservice.business.dtos.requests.individualCustomer.CreateIndividualCustomerRequest;
import com.etiyacrm.customerservice.business.dtos.requests.individualCustomer.UpdateIndividualCustomerRequest;
import com.etiyacrm.customerservice.business.dtos.responses.individualCustomer.*;
import com.etiyacrm.customerservice.core.utilities.mapping.ModelMapperService;
import com.etiyacrm.customerservice.dataAccess.abstracts.CustomerRepository;
import com.etiyacrm.customerservice.dataAccess.abstracts.IndividualCustomerRepository;
import com.etiyacrm.customerservice.entities.Customer;
import com.etiyacrm.customerservice.entities.IndividualCustomer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class IndividualIndividualCustomerManager implements IndividualCustomerService {
    private ModelMapperService modelMapperService;
    private IndividualCustomerRepository individualCustomerRepository;
    private CustomerRepository customerRepository; //Sonra değiştir

    @Override
    public CreatedIndividualCustomerResponse add(CreateIndividualCustomerRequest createIndividualCustomerRequest) {
        Customer mappedCustomer = new Customer();
        mappedCustomer.setEmail(createIndividualCustomerRequest.getEmail());
        Customer addedCustomer = customerRepository.save(mappedCustomer);
        IndividualCustomer mappedIndividualCustomer = modelMapperService.forRequest().map(createIndividualCustomerRequest,IndividualCustomer.class);
        mappedIndividualCustomer.getCustomer().setId(addedCustomer.getId());
        IndividualCustomer createdIndividualCustomer = individualCustomerRepository.save(mappedIndividualCustomer);
        return modelMapperService.forResponse().map(createdIndividualCustomer, CreatedIndividualCustomerResponse.class);
    }

    @Override
    public UpdatedIndividualCustomerResponse update(long id, UpdateIndividualCustomerRequest updateIndividualCustomerRequest) {
        IndividualCustomer getIndividualCustomerById = findById(id);
        IndividualCustomer mappedIndividualCustomer = modelMapperService.forRequest().map(updateIndividualCustomerRequest, IndividualCustomer.class);
        mappedIndividualCustomer.setId(id);
        mappedIndividualCustomer.getCustomer().setId(getIndividualCustomerById.getCustomer().getId());
        mappedIndividualCustomer.setCreatedDate(getIndividualCustomerById.getCreatedDate());
        IndividualCustomer updatedCustomer = individualCustomerRepository.save(mappedIndividualCustomer);
        return modelMapperService.forResponse().map(updatedCustomer, UpdatedIndividualCustomerResponse.class);
    }

    @Override
    public DeletedIndividualCustomerResponse delete(long id) {
        IndividualCustomer getIndividualCustomerById = findById(id);
        getIndividualCustomerById.setDeletedDate(LocalDateTime.now());
        IndividualCustomer deletedCustomer = individualCustomerRepository.save(getIndividualCustomerById);
        return modelMapperService.forResponse().map(deletedCustomer, DeletedIndividualCustomerResponse.class);
    }

    @Override
    public List<GetListIndividualCustomerResponse> getAll() {
        List<IndividualCustomer> individualCustomers = individualCustomerRepository.findAll();
        return individualCustomers.stream().filter(customer -> customer.getDeletedDate() == null)
                .map(individualCustomer -> modelMapperService.forResponse()
                        .map(individualCustomer, GetListIndividualCustomerResponse.class)).collect(Collectors.toList());
    }

    @Override
    public GetIndividualCustomerResponse getById(long id) {
        IndividualCustomer individualCustomer = findById(id);
        return modelMapperService.forResponse().map(individualCustomer, GetIndividualCustomerResponse.class);
    }

    @Override
    public IndividualCustomer findById(long id) {
        return individualCustomerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Individual Customer not found"));
    }

}
