package com.etiyacrm.customerservice.services.mappers;

import com.etiyacrm.customerservice.entities.Address;
import com.etiyacrm.customerservice.entities.City;
import com.etiyacrm.customerservice.services.dtos.requests.address.CreateAddressRequest;
import com.etiyacrm.customerservice.services.dtos.requests.address.UpdateAddressRequest;
import com.etiyacrm.customerservice.services.dtos.responses.address.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AddressMapper {
    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);
    @Mapping(source = "customer.id", target = "customerId")
    @Mapping(source = "city.id", target = "cityId")
    GetAllAddressResponse getAllAddressResponseFromAddress(Address address);
    Address addressFromCreateAddressRequest(CreateAddressRequest createAddressRequest);
    CreatedAddressResponse createdAddressResponseFromAddress(Address address);
    Address addressFromUpdateAddressRequest(UpdateAddressRequest updateAddressRequest);
    UpdatedAddressResponse updatedAddressResponseFromAddress(Address address);
    @Mapping(source = "customer.id", target = "customerId")
    @Mapping(source = "city.id", target = "cityId")
    @Mapping(source = "city.name", target = "cityName")
    GetAddressResponse getAddressResponseFromAddress(Address address);
    DeletedAddressResponse deletedAddressResponseFromAddress(Address address);

}
