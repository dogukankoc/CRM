package com.etiyacrm.customerservice.services.rules;

import com.etiyacrm.customerservice.core.crossCusttingConcerns.types.BusinessException;
import com.etiyacrm.customerservice.entities.City;
import com.etiyacrm.customerservice.repositories.CityRepository;
import com.etiyacrm.customerservice.services.messages.CityMessages;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CityBusinessRules {
    private CityRepository cityRepository;

    public void cityNameCanNotBeDuplicatedWhenInserted(String name){
        Optional<City> city = cityRepository.findByNameIgnoreCase(name);
        if(city.isPresent()){
            throw new BusinessException(CityMessages.cityNameExists);
        }

    }
}
