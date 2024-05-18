package com.etiyacrm.customerservice.adapters;

import com.etiyacrm.customerservice.entities.Customer;
import com.etiyacrm.customerservice.entities.IndividualCustomer;
import com.etiyacrm.customerservice.outservices.mernis.EEFKPSPublicSoap;
import com.etiyacrm.customerservice.services.dtos.requests.individualCustomer.CheckNationalityIdentityRequest;
import org.apache.commons.lang.WordUtils;
import org.springframework.stereotype.Service;

@Service
public class MernisServiceAdapter implements CustomerCheckService{
    @Override
    public boolean checkIfRealPerson(CheckNationalityIdentityRequest checkNationalityIdentityRequest) throws Exception {
        EEFKPSPublicSoap client = new EEFKPSPublicSoap();
        String formattedFirstName = checkNationalityIdentityRequest.getFirstName().toLowerCase();
        String formattedLastName = checkNationalityIdentityRequest.getLastName().toLowerCase();
        formattedFirstName = WordUtils.capitalize(formattedFirstName);
        formattedLastName = WordUtils.capitalize(formattedLastName);
        return client.TCKimlikNoDogrula(
                Long.parseLong(checkNationalityIdentityRequest.getNationalityIdentity()),
                formattedFirstName,
                formattedLastName,
                checkNationalityIdentityRequest.getBirthDate());
    }
}
