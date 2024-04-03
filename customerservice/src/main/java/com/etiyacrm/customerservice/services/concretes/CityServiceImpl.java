package com.etiyacrm.customerservice.services.concretes;

import com.etiyacrm.customerservice.core.business.paging.PageInfo;
import com.etiyacrm.customerservice.core.crossCusttingConcerns.types.BusinessException;
import com.etiyacrm.customerservice.entities.City;
import com.etiyacrm.customerservice.repositories.CityRepository;
import com.etiyacrm.customerservice.services.abstracts.CityService;
import com.etiyacrm.customerservice.services.dtos.requests.city.CreateCityRequest;
import com.etiyacrm.customerservice.services.dtos.requests.city.UpdateCityRequest;
import com.etiyacrm.customerservice.services.dtos.responses.city.*;
import com.etiyacrm.customerservice.services.mappers.CityMapper;
import com.etiyacrm.customerservice.services.rules.CityBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CityServiceImpl implements CityService {

    private CityRepository cityRepository;
    private CityBusinessRules cityBusinessRules;

    @Override
    public List<GetAllCityResponse> getAll(PageInfo pageInfo) {
        Pageable pageable = PageRequest.of(pageInfo.getPage(), pageInfo.getSize());
        Page<City> response = cityRepository.findAll(pageable);
        return response.stream().filter(city -> city.getDeletedDate() == null).map(city -> CityMapper.INSTANCE.getAllCityResponseFromCity(city)).collect(Collectors.toList());
    }

    @Override
    public CreatedCityResponse add(CreateCityRequest createCityRequest) {
        cityBusinessRules.cityNameCanNotBeDuplicatedWhenInserted(createCityRequest.getName());
        City city = CityMapper.INSTANCE.cityFromCreateCityRequest(createCityRequest);
        City createdCity = cityRepository.save(city);
        return CityMapper.INSTANCE.createdCityResponseFromCity(createdCity);
    }

    @Override
    public UpdatedCityResponse update(long id, UpdateCityRequest updateCityRequest) {
        cityBusinessRules.cityNameCanNotBeDuplicatedWhenInserted(updateCityRequest.getName());
        City getCityById = findById(id);
        City mappedCity = CityMapper.INSTANCE.cityFromUpdateCityRequest((updateCityRequest));
        mappedCity.setCreatedDate(getCityById.getCreatedDate());
        mappedCity.setId(id);
        City updatedCity = cityRepository.save(mappedCity);
        return CityMapper.INSTANCE.updatedCityResponseFromCity(updatedCity);
    }

    @Override
    public GetCityResponse getById(long id) {
        cityBusinessRules.cityHasBeenDeleted(id);
        City getCityById = findById(id);
        return CityMapper.INSTANCE.getCityResponseFromCity(getCityById);

    }

    @Override
    public DeletedCityResponse delete(long id) {
        cityBusinessRules.cityHasBeenDeleted(id);
        City getCityById = findById(id);
        getCityById.setDeletedDate(LocalDateTime.now());
        City deletedCity = cityRepository.save(getCityById);
        return CityMapper.INSTANCE.deletedCityResponseFromCity(deletedCity);
    }

    @Override
    public City findById(long id) {
        cityBusinessRules.cityIdIsExist(id);
        return cityRepository.findById(id).orElseThrow(() -> new BusinessException("City not found"));
    }
}
