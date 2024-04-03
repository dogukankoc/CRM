package com.etiyacrm.customerservice.services.mappers;

import com.etiyacrm.customerservice.entities.IndividualCustomer;
import com.etiyacrm.customerservice.services.dtos.requests.individualCustomer.CreateIndividualCustomerRequest;
import com.etiyacrm.customerservice.services.dtos.requests.individualCustomer.UpdateIndividualCustomerRequest;
import com.etiyacrm.customerservice.services.dtos.responses.individualCustomer.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IndividualCustomerMapper {
    IndividualCustomerMapper INSTANCE = Mappers.getMapper(IndividualCustomerMapper.class);

    GetAllIndividualCustomerResponse getAllIndividualCustomerResponseFromIndividualCustomer(IndividualCustomer individualCustomer);

    //Create Mapping
    IndividualCustomer individualCustomerFromCreateIndividualCustomerRequest(CreateIndividualCustomerRequest createIndividualCustomerRequest);
    CreatedIndividualCustomerResponse createdIndividualCustomerResponseFromIndividualCustomer(IndividualCustomer individualCustomer);

    //Update Mapping
    IndividualCustomer individualCustomerFromUpdateIndividualCustomerRequest(UpdateIndividualCustomerRequest updateIndividualCustomerRequest);
    UpdatedIndividualCustomerResponse updatedIndividualCustomerResponseFromIndividualCustomer(IndividualCustomer individualCustomer);

    GetIndividualCustomerResponse getIndividualCustomerResponseFromIndividualCustomer(IndividualCustomer individualCustomer);

    DeletedIndividualCustomerResponse deletedIndividualCustomerResponseFromIndividualCustomer(IndividualCustomer individualCustomer);
}
