package com.etiyacrm.customerservice.controllers;

import com.etiyacrm.customerservice.core.business.paging.PageInfo;
import com.etiyacrm.customerservice.services.abstracts.AddressService;
import com.etiyacrm.customerservice.services.dtos.requests.address.CreateAddressRequest;
import com.etiyacrm.customerservice.services.dtos.requests.address.UpdateAddressRequest;
import com.etiyacrm.customerservice.services.dtos.responses.address.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/addresses")
public class AddressController {

    private AddressService addressService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetAddressResponse getById(@PathVariable long id) {

        return addressService.getById(id);
    }

    @GetMapping("customer/{customerId}")
    @ResponseStatus(HttpStatus.OK)
    public List<GetAddressResponse> getByCustomerId(@PathVariable String customerId){
        return addressService.getByCustomerId(customerId);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllAddressResponse> getAll() {

        return addressService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedAddressResponse add(@Valid @RequestBody CreateAddressRequest createAddressRequest) {
        return addressService.add(createAddressRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UpdatedAddressResponse update(@Valid @PathVariable long id, @RequestBody UpdateAddressRequest updateAddressRequest) {
        return addressService.update(id, updateAddressRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DeletedAddressResponse delete(@PathVariable long id) {
        return addressService.delete(id);
    }
}
