package com.etiyacrm.customerservice.services.rules;


import com.etiyacrm.common.business.abstracts.MessageService;

import com.etiyacrm.common.exceptions.types.BusinessException;
import com.etiyacrm.customerservice.entities.City;
import com.etiyacrm.customerservice.repositories.CityRepository;
import com.etiyacrm.customerservice.services.messages.Messages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CityBusinessRules {
    private CityRepository cityRepository;
    private MessageService messageService;

    public void cityNameCanNotBeDuplicatedWhenInserted(String name) {
        Optional<City> city = cityRepository.findByNameIgnoreCase(name);

        if (city.isPresent()) {
            throw new BusinessException(messageService.getMessage(Messages.BusinessErrors.CityNameExists));
        }
    }

    public void cityIdIsExist(long id) {
        Optional<City> city = cityRepository.findById(id);
        if (city.isEmpty()) {
            throw new BusinessException(messageService.getMessage(Messages.BusinessErrors.CityIdNotAvailable));
        }
    }

    public void cityHasBeenDeleted(long id) {
        Optional<City> city = cityRepository.findById(id);
        if (city.get().getDeletedDate() != null) {
            throw new BusinessException(messageService.getMessage(Messages.BusinessErrors.CityHasBeenDeleted));
        }
    }
}
