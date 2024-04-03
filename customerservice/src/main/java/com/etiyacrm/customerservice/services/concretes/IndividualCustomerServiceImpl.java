package com.etiyacrm.customerservice.services.concretes;

import com.etiyacrm.customerservice.entities.City;
import com.etiyacrm.customerservice.services.abstracts.CustomerService;
import com.etiyacrm.customerservice.services.abstracts.IndividualCustomerService;
import com.etiyacrm.customerservice.services.dtos.requests.individualCustomer.CreateIndividualCustomerRequest;
import com.etiyacrm.customerservice.services.dtos.requests.individualCustomer.UpdateIndividualCustomerRequest;
import com.etiyacrm.customerservice.services.dtos.responses.individualCustomer.*;
import com.etiyacrm.customerservice.core.crossCusttingConcerns.mapping.ModelMapperService;
import com.etiyacrm.customerservice.repositories.CustomerRepository;
import com.etiyacrm.customerservice.repositories.IndividualCustomerRepository;
import com.etiyacrm.customerservice.entities.Customer;
import com.etiyacrm.customerservice.entities.IndividualCustomer;
import com.etiyacrm.customerservice.services.mappers.CityMapper;
import com.etiyacrm.customerservice.services.mappers.IndividualCustomerMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.etiyacrm.customerservice.core.business.paging.PageInfo;


import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class IndividualCustomerServiceImpl implements IndividualCustomerService {
    private ModelMapperService modelMapperService;
    private IndividualCustomerRepository individualCustomerRepository;
    private CustomerRepository customerRepository; //Sonra değiştir
    private CustomerService customerService;


    @Override
    public CreatedIndividualCustomerResponse add(CreateIndividualCustomerRequest createIndividualCustomerRequest) {
        Customer mappedCustomer = new Customer();
        mappedCustomer.setEmail(createIndividualCustomerRequest.getEmail());
        Customer addedCustomer = customerRepository.save(mappedCustomer);
        IndividualCustomer mappedIndividualCustomer = IndividualCustomerMapper.INSTANCE.individualCustomerFromCreateIndividualCustomerRequest(createIndividualCustomerRequest);
        mappedIndividualCustomer.getCustomer().setId(addedCustomer.getId());
        IndividualCustomer createdIndividualCustomer = individualCustomerRepository.save(mappedIndividualCustomer);
        return IndividualCustomerMapper.INSTANCE.createdIndividualCustomerResponseFromIndividualCustomer(createdIndividualCustomer);
    }

    @Override
    public UpdatedIndividualCustomerResponse update(long id, UpdateIndividualCustomerRequest updateIndividualCustomerRequest) {

        IndividualCustomer getIndividualCustomerById = findById(id);
        IndividualCustomer mappedIndividualCustomer = IndividualCustomerMapper.INSTANCE.individualCustomerFromUpdateIndividualCustomerRequest(updateIndividualCustomerRequest);
        mappedIndividualCustomer.setId(id);
        mappedIndividualCustomer.getCustomer().setId(getIndividualCustomerById.getCustomer().getId());
        mappedIndividualCustomer.setCreatedDate(getIndividualCustomerById.getCreatedDate());
        IndividualCustomer updatedIndividualCustomer = individualCustomerRepository.save(mappedIndividualCustomer);

        Customer getCustomerById = customerService.findById(updatedIndividualCustomer.getCustomer().getId());
        getCustomerById.setUpdatedDate(updatedIndividualCustomer.getUpdatedDate());
        getCustomerById.setEmail(updateIndividualCustomerRequest.getEmail());
        Customer updatedCustomer = customerRepository.save(getCustomerById);
        updatedIndividualCustomer.setCustomer(updatedCustomer);

        return IndividualCustomerMapper.INSTANCE.updatedIndividualCustomerResponseFromIndividualCustomer(updatedIndividualCustomer);
    }



    @Override
    public DeletedIndividualCustomerResponse delete(long id) {
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
    public List<GetAllIndividualCustomerResponse> getAll(PageInfo pageInfo) {
        Pageable pageable = PageRequest.of(pageInfo.getPage(), pageInfo.getSize());
        Page<IndividualCustomer> response = individualCustomerRepository.findAll(pageable);
        return response.stream().filter(individualCustomer -> individualCustomer.getDeletedDate() == null).map(individualCustomer -> IndividualCustomerMapper.INSTANCE.getAllIndividualCustomerResponseFromIndividualCustomer(individualCustomer)).collect(Collectors.toList());
    }

    @Override
    public GetIndividualCustomerResponse getById(long id) {
        IndividualCustomer individualCustomer = findById(id);
        return IndividualCustomerMapper.INSTANCE.getIndividualCustomerResponseFromIndividualCustomer(individualCustomer);
    }


    @Override
    public IndividualCustomer findById(long id) {
        return individualCustomerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Individual Customer not found"));
    }
}



