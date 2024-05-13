package com.etiya.searchservice.controllers;

import com.etiya.searchservice.service.abstracts.FilterService;
import com.etiya.searchservice.service.dtos.requests.PostSearchCustomerRequest;
import com.etiya.searchservice.service.dtos.responses.PostSearchCustomerResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("searchservice/api/v1/searchcustomer")
@AllArgsConstructor
public class SearchCustomerController {
    private FilterService filterService;

    @PostMapping
    public List<PostSearchCustomerResponse> searchCustomer(@RequestBody PostSearchCustomerRequest postSearchCustomerRequest) {
        return filterService.searchCustomers(postSearchCustomerRequest);
    }
}
