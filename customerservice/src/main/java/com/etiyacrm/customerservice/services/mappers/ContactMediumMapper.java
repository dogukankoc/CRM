package com.etiyacrm.customerservice.services.mappers;

import com.etiyacrm.customerservice.entities.ContactMedium;
import com.etiyacrm.customerservice.services.dtos.requests.contactMedium.CreateContactMediumRequest;
import com.etiyacrm.customerservice.services.dtos.requests.contactMedium.UpdateContactMediumRequest;
import com.etiyacrm.customerservice.services.dtos.responses.contactMedium.CreatedContactMediumResponse;
import com.etiyacrm.customerservice.services.dtos.responses.contactMedium.DeletedContactMediumResponse;
import com.etiyacrm.customerservice.services.dtos.responses.contactMedium.GetContactMediumResponse;
import com.etiyacrm.customerservice.services.dtos.responses.contactMedium.UpdatedContactMediumResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ContactMediumMapper {
    ContactMediumMapper INSTANCE = Mappers.getMapper(ContactMediumMapper.class);

    CreatedContactMediumResponse createdContactMediumResponseFromContactMedium(ContactMedium contactMedium);
    UpdatedContactMediumResponse updatedContactMediumResponseFromContactMedium(ContactMedium contactMedium);
    GetContactMediumResponse getContactMediumResponseFromContactMedium(ContactMedium contactMedium);
    DeletedContactMediumResponse deletedContactMediumResponseFromContactMedium(ContactMedium contactMedium);
    ContactMedium contactMediumFromCreateContactMediumRequest(CreateContactMediumRequest createContactMediumRequest);
    ContactMedium contactMediumFromUpdateContactMediumRequest(UpdateContactMediumRequest updateContactMediumRequest);
}