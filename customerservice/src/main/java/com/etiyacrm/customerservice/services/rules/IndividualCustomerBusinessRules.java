package com.etiyacrm.customerservice.services.rules;

import com.etiyacrm.customerservice.adapters.CustomerCheckService;
import com.etiyacrm.customerservice.core.business.abstracts.MessageService;
import com.etiyacrm.customerservice.core.crossCusttingConcerns.types.BusinessException;
import com.etiyacrm.customerservice.entities.IndividualCustomer;
import com.etiyacrm.customerservice.repositories.IndividualCustomerRepository;
import com.etiyacrm.customerservice.services.dtos.requests.individualCustomer.CheckNationalityIdentityRequest;
import com.etiyacrm.customerservice.services.messages.Messages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class IndividualCustomerBusinessRules {
    private IndividualCustomerRepository individualCustomerRepository;
    private MessageService messageService;
    private CustomerCheckService customerCheckService;


    public void individualCustomerNationalityIdentityCanNotBeDuplicatedWhenInserted(String nationalityIdentity) {
        Optional<IndividualCustomer> individualCustomer = individualCustomerRepository.findByNationalityIdentityIgnoreCase(nationalityIdentity);

        if (individualCustomer.isPresent()) {
            throw new BusinessException(messageService.getMessage(Messages.BusinessErrors.NationalityIdentityExists));
        }
    }

    public Boolean individualCustomerNationalityIdentityCanNotBeDuplicatedWhenInsertedForClient(String nationalityIdentity) {
        Optional<IndividualCustomer> individualCustomer = individualCustomerRepository.findByNationalityIdentityIgnoreCase(nationalityIdentity);

        if (individualCustomer.isPresent()) {
            return true;
        } else {
            return false;
        }
    }

    public void individualCustomerIdIsExist(String id) {
        Optional<IndividualCustomer> individualCustomer = individualCustomerRepository.findById(id);
        if (individualCustomer.isEmpty()) {
            throw new BusinessException(messageService.getMessage(Messages.BusinessErrors.IndividualCustomerIdNotAvailable));
        }
    }

    public void individualCustomerHasBeenDeleted(String id) {
        Optional<IndividualCustomer> individualCustomer = individualCustomerRepository.findById(id);
        if (individualCustomer.get().getDeletedDate() != null) {
            throw new BusinessException(messageService.getMessage(Messages.BusinessErrors.IndividualCustomerHasBeenDeleted));
        }
    }

    public Boolean checkIfNationalIdentityExists(CheckNationalityIdentityRequest checkNationalityIdentityRequest) throws Exception {
        try {
            if (!customerCheckService.checkIfRealPerson(checkNationalityIdentityRequest)) {
                throw new BusinessException(messageService.getMessage(Messages.BusinessErrors.IdentityNumberNotExists));
            }
            return false;
        } catch (BusinessException e) {

            return true;
        }
    }

}
