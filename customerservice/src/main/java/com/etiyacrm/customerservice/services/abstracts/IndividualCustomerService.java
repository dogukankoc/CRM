package com.etiyacrm.customerservice.services.abstracts;

import com.etiyacrm.customerservice.core.business.paging.PageInfo;
import com.etiyacrm.customerservice.services.dtos.requests.individualCustomer.CheckNationalityIdentityRequest;
import com.etiyacrm.customerservice.services.dtos.requests.individualCustomer.CreateIndividualCustomerRequest;
import com.etiyacrm.customerservice.services.dtos.requests.individualCustomer.UpdateIndividualCustomerRequest;
import com.etiyacrm.customerservice.services.dtos.responses.individualCustomer.*;
import com.etiyacrm.customerservice.entities.IndividualCustomer;

import java.util.List;

public interface IndividualCustomerService {
    CreatedIndividualCustomerResponse add(CreateIndividualCustomerRequest createIndividualCustomerRequest);
    UpdatedIndividualCustomerResponse update(String id, UpdateIndividualCustomerRequest updateIndividualCustomerRequest);
    IndividualCustomer findById(String id);
    DeletedIndividualCustomerResponse delete(String id);
    List<GetAllIndividualCustomerResponse> getAll();
    GetIndividualCustomerResponse getById(String id);
    Boolean checkByNationalityIdentity(String nationalityIdentity);
    public Boolean checkIfNationalIdentityExists(CheckNationalityIdentityRequest checkNationalityIdentityRequest) throws Exception;
}
