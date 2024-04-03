package com.etiyacrm.customerservice.controllers;

import com.etiyacrm.customerservice.services.abstracts.CityService;
import com.etiyacrm.customerservice.services.dtos.requests.city.CreateCityRequest;
import com.etiyacrm.customerservice.services.dtos.responses.city.CreatedCityResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/cities")
public class CitiesController {
    private CityService cityService;

    @PostMapping
    public CreatedCityResponse add(@Valid @RequestBody CreateCityRequest createCityRequest){
        return cityService.add(createCityRequest);
    }

}
