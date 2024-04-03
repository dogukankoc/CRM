package com.etiyacrm.customerservice.services.mappers;

import com.etiyacrm.customerservice.entities.City;
import com.etiyacrm.customerservice.services.dtos.requests.city.CreateCityRequest;
import com.etiyacrm.customerservice.services.dtos.responses.city.CreatedCityResponse;
import com.etiyacrm.customerservice.services.dtos.responses.city.GetAllCityResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

public interface CityMapper {
    CityMapper INSTANCE = Mappers.getMapper(CityMapper.class);

    GetAllCityResponse getAllCityResponseFromCity(City city);
    City cityFromCreateCityRequest(CreateCityRequest createCityRequest);
    CreatedCityResponse createdCityResponseFromCity(City city);


}
