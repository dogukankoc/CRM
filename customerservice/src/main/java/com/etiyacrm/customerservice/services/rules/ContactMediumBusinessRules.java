package com.etiyacrm.customerservice.services.rules;


import com.etiyacrm.common.business.abstracts.MessageService;

import com.etiyacrm.common.exceptions.types.BusinessException;
import com.etiyacrm.customerservice.entities.ContactMedium;
import com.etiyacrm.customerservice.entities.Customer;
import com.etiyacrm.customerservice.repositories.ContactMediumRepository;
import com.etiyacrm.customerservice.services.abstracts.CustomerService;
import com.etiyacrm.customerservice.services.messages.Messages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ContactMediumBusinessRules {
    private ContactMediumRepository cotactMediumRepository;
    private MessageService messageService;
    private CustomerService customerService;

    public void contactMediumIdIsExist(long id) {
        Optional<ContactMedium> contactMedium = cotactMediumRepository.findById(id);
        if (contactMedium.isEmpty()) {
            throw new BusinessException(messageService.getMessage(Messages.BusinessErrors.ContactMediumIdNotAvailable));
        }
     }



}
