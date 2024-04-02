package com.etiyacrm.customerservice.business.concretes;

import com.etiyacrm.customerservice.business.abstracts.IndividualCustomerService;
import com.etiyacrm.customerservice.business.dtos.requests.individualCustomer.CreateIndividualCustomerRequest;
import com.etiyacrm.customerservice.business.dtos.requests.individualCustomer.UpdateIndividualCustomerRequest;
import com.etiyacrm.customerservice.business.dtos.responses.individualCustomer.*;
import com.etiyacrm.customerservice.core.utilities.mapping.ModelMapperService;
import com.etiyacrm.customerservice.dataAccess.abstracts.IndividualCustomerRepository;
import com.etiyacrm.customerservice.entities.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class IndividualIndividualCustomerManager implements IndividualCustomerService {
    private ModelMapperService modelMapperService;
    private IndividualCustomerRepository individualCustomerRepository;

    @Override
    public CreatedIndividualCustomerResponse add(CreateIndividualCustomerRequest createIndividualCustomerRequest) {
        Customer mappedCustomer = modelMapperService.forRequest().map(createIndividualCustomerRequest,Customer.class);
        Customer createdCustomer = individualCustomerRepository.save(mappedCustomer);
        return modelMapperService.forResponse().map(createdCustomer, CreatedIndividualCustomerResponse.class);
    }

    @Override
    public UpdatedIndividualCustomerResponse update(long id, UpdateIndividualCustomerRequest updateIndividualCustomerRequest) {
        Customer getCustomerById = findById(id);
        Customer mappedCustomer = modelMapperService.forRequest().map(updateIndividualCustomerRequest, Customer.class);
        mappedCustomer.setId(id);
        mappedCustomer.setCreatedDate(getCustomerById.getCreatedDate());
        Customer updatedCustomer = individualCustomerRepository.save(mappedCustomer);
        return modelMapperService.forResponse().map(updatedCustomer, UpdatedIndividualCustomerResponse.class);
    }

    @Override
    public DeletedIndividualCustomerResponse delete(long id) {
        Customer customer = findById(id);
        customer.setDeletedDate(LocalDateTime.now());
        Customer deletedCustomer = individualCustomerRepository.save(customer);
        return modelMapperService.forResponse().map(deletedCustomer, DeletedIndividualCustomerResponse.class);
    }

    @Override
    public List<GetListIndividualCustomerResponse> getAll() {
        List<Customer> customers = individualCustomerRepository.findAll();
        return customers.stream().filter(customer -> customer.getDeletedDate() == null)
                .map(customer -> modelMapperService.forResponse()
                        .map(customer, GetListIndividualCustomerResponse.class)).collect(Collectors.toList());
    }

    @Override
    public GetIndividualCustomerResponse getById(long id) {
        Customer customer = findById(id);
        return modelMapperService.forResponse().map(customer, GetIndividualCustomerResponse.class);
    }

    @Override
    public Customer findById(long id) {
        return individualCustomerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Customer not found"));
    }

}
