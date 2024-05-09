package com.etiyacrm.customerservice.controllers;

import com.etiyacrm.customerservice.core.business.paging.PageInfo;
import com.etiyacrm.customerservice.services.abstracts.CityService;
import com.etiyacrm.customerservice.services.dtos.requests.city.CreateCityRequest;
import com.etiyacrm.customerservice.services.dtos.requests.city.UpdateCityRequest;
import com.etiyacrm.customerservice.services.dtos.responses.city.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("customerservice/api/v1/cities")
@CrossOrigin(origins = "*")
public class CitiesController {

    private CityService cityService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetCityResponse getById(@PathVariable long id) {

        return cityService.getById(id);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public GetAllCityResponse getAll(PageInfo pageInfo) {

        return cityService.getAll(pageInfo);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedCityResponse add(@Valid @RequestBody CreateCityRequest createCityRequest) {
        return cityService.add(createCityRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UpdatedCityResponse update(@Valid @PathVariable long id, @RequestBody UpdateCityRequest updateCityRequest) {
        return cityService.update(id, updateCityRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DeletedCityResponse delete(@PathVariable long id) {
        return cityService.delete(id);
    }

}
