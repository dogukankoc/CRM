package com.etiyacrm.customerservice.services.mappers;

import com.etiyacrm.customerservice.core.business.paging.PageInfo;
import com.etiyacrm.customerservice.entities.City;
import com.etiyacrm.customerservice.services.dtos.requests.city.CreateCityRequest;
import com.etiyacrm.customerservice.services.dtos.requests.city.UpdateCityRequest;
import com.etiyacrm.customerservice.services.dtos.responses.city.*;
import com.etiyacrm.customerservice.services.dtos.responses.pagging.GetPageInfoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CityMapper {
    CityMapper INSTANCE = Mappers.getMapper(CityMapper.class);

    GetAllCityResponse getAllCityResponseFromCity(City city);

    //Create Mapping
    City cityFromCreateCityRequest(CreateCityRequest createCityRequest);
    CreatedCityResponse createdCityResponseFromCity(City city);

    //Update Mapping
    City cityFromUpdateCityRequest(UpdateCityRequest updateCityRequest);
    UpdatedCityResponse updatedCityResponseFromCity(City city);

    GetCityResponse getCityResponseFromCity(City city);

    DeletedCityResponse deletedCityResponseFromCity(City city);

    GetPageInfoResponse pageInfo(GetPageInfoResponse getPageInfoResponsenfo);


}
