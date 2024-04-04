package com.etiyacrm.customerservice.services.abstracts;

import com.etiyacrm.customerservice.core.business.paging.PageInfo;
import com.etiyacrm.customerservice.entities.City;
import com.etiyacrm.customerservice.entities.IndividualCustomer;
import com.etiyacrm.customerservice.services.dtos.requests.city.CreateCityRequest;
import com.etiyacrm.customerservice.services.dtos.requests.city.UpdateCityRequest;
import com.etiyacrm.customerservice.services.dtos.responses.city.*;

import java.util.List;

public interface CityService {
    GetAllCityResponse getAll(PageInfo pageInfo);

    CreatedCityResponse add(CreateCityRequest createCityRequest);

    UpdatedCityResponse update(long id, UpdateCityRequest updateCityRequest);

    GetCityResponse getById(long id);

    DeletedCityResponse delete(long id);

    City findById(long id);

}
