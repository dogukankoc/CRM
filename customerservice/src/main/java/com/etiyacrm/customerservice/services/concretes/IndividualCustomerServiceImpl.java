package com.etiyacrm.customerservice.services.concretes;

import com.etiyacrm.common.events.customers.CustomerCreatedEvent;
import com.etiyacrm.customerservice.adapters.CustomerCheckService;
import com.etiyacrm.customerservice.kafka.producers.CustomerProducer;
import com.etiyacrm.customerservice.services.abstracts.CustomerService;
import com.etiyacrm.customerservice.services.abstracts.IndividualCustomerService;
import com.etiyacrm.customerservice.services.dtos.requests.individualCustomer.CheckNationalityIdentityRequest;
import com.etiyacrm.customerservice.services.dtos.requests.individualCustomer.CreateIndividualCustomerRequest;
import com.etiyacrm.customerservice.services.dtos.requests.individualCustomer.UpdateIndividualCustomerRequest;
import com.etiyacrm.customerservice.services.dtos.responses.individualCustomer.*;
import com.etiyacrm.customerservice.repositories.CustomerRepository;
import com.etiyacrm.customerservice.repositories.IndividualCustomerRepository;
import com.etiyacrm.customerservice.entities.Customer;
import com.etiyacrm.customerservice.entities.IndividualCustomer;
import com.etiyacrm.customerservice.services.mappers.CityMapper;
import com.etiyacrm.customerservice.services.mappers.IndividualCustomerMapper;
import com.etiyacrm.customerservice.services.rules.IndividualCustomerBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.etiyacrm.customerservice.core.business.paging.PageInfo;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class IndividualCustomerServiceImpl implements IndividualCustomerService {
    private IndividualCustomerRepository individualCustomerRepository;
    private CustomerRepository customerRepository; //Sonra değiştir
    private CustomerService customerService;
    private IndividualCustomerBusinessRules individualCustomerBusinessRules;
    private CustomerProducer customerProducer;



    @Override
    public CreatedIndividualCustomerResponse add(CreateIndividualCustomerRequest createIndividualCustomerRequest) {
        individualCustomerBusinessRules.individualCustomerNationalityIdentityCanNotBeDuplicatedWhenInserted(createIndividualCustomerRequest.getNationalityIdentity());

        Customer mappedCustomer = new Customer();
        Customer addedCustomer = customerRepository.save(mappedCustomer);
        IndividualCustomer mappedIndividualCustomer = IndividualCustomerMapper.INSTANCE.individualCustomerFromCreateIndividualCustomerRequest(createIndividualCustomerRequest);
        mappedIndividualCustomer.setCustomer(addedCustomer);
        mappedIndividualCustomer.getCustomer().setId(addedCustomer.getId());
        IndividualCustomer createdIndividualCustomer = individualCustomerRepository.save(mappedIndividualCustomer);
        CreatedIndividualCustomerResponse createdIndividualCustomerResponse = IndividualCustomerMapper.INSTANCE.createdIndividualCustomerResponseFromIndividualCustomer(createdIndividualCustomer);
        createdIndividualCustomerResponse.setCustomerId(createdIndividualCustomer.getCustomer().getId());
        CustomerCreatedEvent customerCreatedEvent = new CustomerCreatedEvent(
                createdIndividualCustomerResponse.getId(),
                createdIndividualCustomerResponse.getFirstName(),
                createdIndividualCustomerResponse.getMiddleName(),
                createdIndividualCustomerResponse.getLastName(),
                createdIndividualCustomerResponse.getFatherName(),
                createdIndividualCustomerResponse.getNationalityIdentity()
        );
        customerProducer.sendMessage(customerCreatedEvent);
        return createdIndividualCustomerResponse;
    }

    @Override
    public UpdatedIndividualCustomerResponse update(String id, UpdateIndividualCustomerRequest updateIndividualCustomerRequest) {
        individualCustomerBusinessRules.individualCustomerIdIsExist(id);
//        individualCustomerBusinessRules.individualCustomerNationalityIdentityCanNotBeDuplicatedWhenInserted(updateIndividualCustomerRequest.getNationalityIdentity());
        IndividualCustomer getIndividualCustomerById = findById(id);
        IndividualCustomer mappedIndividualCustomer = IndividualCustomerMapper.INSTANCE.individualCustomerFromUpdateIndividualCustomerRequest(updateIndividualCustomerRequest);
        mappedIndividualCustomer.setId(id);
        mappedIndividualCustomer.setCustomer(getIndividualCustomerById.getCustomer());
        mappedIndividualCustomer.setCreatedDate(getIndividualCustomerById.getCreatedDate());
        IndividualCustomer updatedIndividualCustomer = individualCustomerRepository.save(mappedIndividualCustomer);

        Customer getCustomerById = customerService.findById(updatedIndividualCustomer.getCustomer().getId());
        getCustomerById.setUpdatedDate(updatedIndividualCustomer.getUpdatedDate());
//        getCustomerById.setEmail(updateIndividualCustomerRequest.getEmail());
        Customer updatedCustomer = customerRepository.save(getCustomerById);
        updatedIndividualCustomer.setCustomer(updatedCustomer);

        UpdatedIndividualCustomerResponse updatedIndividualCustomerResponse = IndividualCustomerMapper.INSTANCE.updatedIndividualCustomerResponseFromIndividualCustomer(updatedIndividualCustomer);
//        updatedIndividualCustomerResponse.setEmail(updatedCustomer.getEmail());
        return updatedIndividualCustomerResponse;
    }


    @Override
    public DeletedIndividualCustomerResponse delete(String id) {
//        individualCustomerBusinessRules.individualCustomerHasBeenDeleted(id);
        individualCustomerBusinessRules.individualCustomerIdIsExist(id);
        IndividualCustomer getIndividualCustomerById = findById(id);
        getIndividualCustomerById.setDeletedDate(LocalDateTime.now());
        IndividualCustomer deletedIndividualCustomer = individualCustomerRepository.save(getIndividualCustomerById);
        Customer getCustomerById = customerService.findById(getIndividualCustomerById.getCustomer().getId());
        getCustomerById.setDeletedDate(deletedIndividualCustomer.getDeletedDate());
        Customer deletedCustomer = customerRepository.save(getCustomerById);
        deletedIndividualCustomer.setCustomer(deletedCustomer);
        return IndividualCustomerMapper.INSTANCE.deletedIndividualCustomerResponseFromIndividualCustomer(deletedIndividualCustomer);
    }

    @Override
    public List<GetAllIndividualCustomerResponse> getAll() {
        List<IndividualCustomer> customers = individualCustomerRepository.findAll();
        return customers.stream().filter(customer -> customer.getDeletedDate() == null)
                .map(customer -> IndividualCustomerMapper.INSTANCE.getAllIndividualCustomerResponseFromIndividualCustomer(customer))
                .collect(Collectors.toList());
//        Pageable pageable = PageRequest.of(pageInfo.getPage(), pageInfo.getSize());
//        Page<IndividualCustomer> response = individualCustomerRepository.findAll(pageable);
//        return response.stream().filter(individualCustomer -> individualCustomer.getDeletedDate() == null).map(individualCustomer -> IndividualCustomerMapper.INSTANCE.getAllIndividualCustomerResponseFromIndividualCustomer(individualCustomer)).collect(Collectors.toList());
    }

    @Override
    public GetIndividualCustomerResponse getById(String id) {
//        individualCustomerBusinessRules.individualCustomerHasBeenDeleted(id);
        individualCustomerBusinessRules.individualCustomerIdIsExist(id);
        IndividualCustomer individualCustomer = findById(id);
        GetIndividualCustomerResponse getIndividualCustomerResponse = IndividualCustomerMapper.INSTANCE.getIndividualCustomerResponseFromIndividualCustomer(individualCustomer);
        getIndividualCustomerResponse.setCustomerId(individualCustomer.getCustomer().getId());
//        getIndividualCustomerResponse.setEmail(individualCustomer.getCustomer().getEmail());
        return getIndividualCustomerResponse;
    }

    @Override
    public Boolean checkByNationalityIdentity(String nationalityIdentity) {
        return individualCustomerBusinessRules.individualCustomerNationalityIdentityCanNotBeDuplicatedWhenInsertedForClient(nationalityIdentity);
    }

    @Override
    public Boolean checkIfNationalIdentityExists(CheckNationalityIdentityRequest checkNationalityIdentityRequest) throws Exception {
    return individualCustomerBusinessRules.checkIfNationalIdentityExists(checkNationalityIdentityRequest);
    }


    @Override
    public IndividualCustomer findById(String id) {
        return individualCustomerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Individual Customer not found"));
    }


}




