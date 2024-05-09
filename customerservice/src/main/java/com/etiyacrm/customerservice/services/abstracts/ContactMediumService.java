package com.etiyacrm.customerservice.services.abstracts;


import com.etiyacrm.customerservice.entities.ContactMedium;
import com.etiyacrm.customerservice.services.dtos.requests.contactMedium.CreateContactMediumRequest;
import com.etiyacrm.customerservice.services.dtos.requests.contactMedium.UpdateContactMediumRequest;
import com.etiyacrm.customerservice.services.dtos.responses.contactMedium.CreatedContactMediumResponse;
import com.etiyacrm.customerservice.services.dtos.responses.contactMedium.DeletedContactMediumResponse;
import com.etiyacrm.customerservice.services.dtos.responses.contactMedium.GetContactMediumResponse;
import com.etiyacrm.customerservice.services.dtos.responses.contactMedium.UpdatedContactMediumResponse;

public interface ContactMediumService {
    CreatedContactMediumResponse add(CreateContactMediumRequest createContactMediumRequest);
    UpdatedContactMediumResponse update(long id, UpdateContactMediumRequest updateContactMediumRequest);
    GetContactMediumResponse getById(long id);
    DeletedContactMediumResponse delete(long id);
    ContactMedium findById(long id);
}