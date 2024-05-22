package com.etiya.searchservice.controllers;

import com.etiya.searchservice.service.abstracts.FilterService;
import com.etiya.searchservice.service.dtos.responses.PostSearchCustomerResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.http.HttpStatus;


@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("/api/v1/search-service")
public class SearchCustomerController {
    private FilterService filterService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PostSearchCustomerResponse> search(
            @RequestParam(required = false) String nationalityIdentity,
            @RequestParam(required = false) String customerId,
            @RequestParam(required = false) String accountNumber,
            @RequestParam(required = false) String mobilePhone,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String orderNumber
    ) {
        return this.filterService.search(
                nationalityIdentity, customerId, accountNumber, mobilePhone, firstName, lastName, orderNumber
        );
    }

}
