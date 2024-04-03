package com.etiyacrm.customerservice.services.abstracts;

import com.etiyacrm.customerservice.services.dtos.requests.individualCustomer.CreateIndividualCustomerRequest;
import com.etiyacrm.customerservice.services.dtos.requests.individualCustomer.UpdateIndividualCustomerRequest;
import com.etiyacrm.customerservice.services.dtos.responses.individualCustomer.*;
import com.etiyacrm.customerservice.entities.IndividualCustomer;

import java.util.List;

public interface IndividualCustomerService {
    CreatedIndividualCustomerResponse add(CreateIndividualCustomerRequest createIndividualCustomerRequest);
    UpdatedIndividualCustomerResponse update(long id, UpdateIndividualCustomerRequest updateIndividualCustomerRequest);
    IndividualCustomer findById(long id);
    DeletedIndividualCustomerResponse delete(long id);
    List<GetListIndividualCustomerResponse> getAll();
    GetIndividualCustomerResponse getById(long id);
}
