package com.etiya.searchservice.service.abstracts;

import com.etiya.searchservice.entities.Customer;
import com.etiya.searchservice.service.dtos.requests.PostSearchCustomerRequest;
import com.etiya.searchservice.service.dtos.responses.PostSearchCustomerResponse;

import java.util.List;

public interface FilterService {
    void add(Customer customer);
    List<PostSearchCustomerResponse> searchCustomers(PostSearchCustomerRequest postSearchCustomerRequest);
}