package com.etiya.searchservice.service.abstracts;

import com.etiya.searchservice.entities.Customer;
import com.etiya.searchservice.service.dtos.requests.PostSearchCustomerRequest;
import com.etiya.searchservice.service.dtos.responses.PostSearchCustomerResponse;

import java.util.List;

public interface FilterService {
    void addCustomer(Customer customer);
    List<PostSearchCustomerResponse> search(
            String nationalityIdentity, String id, String accountNumber,
            String mobilePhone, String firstName, String lastName, String orderNumber
    );
}