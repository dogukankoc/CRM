package com.etiyacrm.customerservice.business.abstracts;

import com.etiyacrm.customerservice.business.dtos.requests.individualCustomer.CreateIndividualCustomerRequest;
import com.etiyacrm.customerservice.business.dtos.requests.individualCustomer.UpdateIndividualCustomerRequest;
import com.etiyacrm.customerservice.business.dtos.responses.individualCustomer.*;
import com.etiyacrm.customerservice.entities.Customer;

import java.util.List;

public interface IndividualCustomerService {
    CreatedIndividualCustomerResponse add(CreateIndividualCustomerRequest createIndividualCustomerRequest);
    UpdatedIndividualCustomerResponse update(long id, UpdateIndividualCustomerRequest updateIndividualCustomerRequest);
    Customer findById(long id);
    DeletedIndividualCustomerResponse delete(long id);
    List<GetListIndividualCustomerResponse> getAll();
    GetIndividualCustomerResponse getById(long id);
}
