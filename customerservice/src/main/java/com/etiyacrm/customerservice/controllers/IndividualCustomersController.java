package com.etiyacrm.customerservice.controllers;

import com.etiyacrm.customerservice.core.business.paging.PageInfo;
import com.etiyacrm.customerservice.services.abstracts.IndividualCustomerService;
import com.etiyacrm.customerservice.services.dtos.requests.individualCustomer.CreateIndividualCustomerRequest;
import com.etiyacrm.customerservice.services.dtos.requests.individualCustomer.UpdateIndividualCustomerRequest;
import com.etiyacrm.customerservice.services.dtos.responses.individualCustomer.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/individualCustomers")
@CrossOrigin(origins = "*")
public class IndividualCustomersController {

    private IndividualCustomerService individualCustomerService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetIndividualCustomerResponse getById(@PathVariable String id){

        return individualCustomerService.getById(id);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllIndividualCustomerResponse> getAll(){

        return individualCustomerService.getAll(new PageInfo());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedIndividualCustomerResponse add(@RequestBody CreateIndividualCustomerRequest createIndividualCustomerRequest) {
        return individualCustomerService.add(createIndividualCustomerRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UpdatedIndividualCustomerResponse update(@Valid @PathVariable String id, @RequestBody UpdateIndividualCustomerRequest updateIndividualCustomerRequest) {
        return individualCustomerService.update(id, updateIndividualCustomerRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DeletedIndividualCustomerResponse delete(@PathVariable String id) {
        return individualCustomerService.delete(id);
    }
}
