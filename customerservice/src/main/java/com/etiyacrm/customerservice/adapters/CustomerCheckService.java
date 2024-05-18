package com.etiyacrm.customerservice.adapters;

import com.etiyacrm.customerservice.entities.Customer;
import com.etiyacrm.customerservice.entities.IndividualCustomer;
import com.etiyacrm.customerservice.services.dtos.requests.individualCustomer.CheckNationalityIdentityRequest;

public interface CustomerCheckService {
    public boolean checkIfRealPerson(CheckNationalityIdentityRequest checkNationalityIdentityRequest) throws Exception;
}
