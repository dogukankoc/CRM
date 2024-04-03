package com.etiyacrm.customerservice.services.abstracts;

import com.etiyacrm.customerservice.entities.City;
import com.etiyacrm.customerservice.entities.Customer;

public interface CustomerService {
    Customer findById(long id);
}
