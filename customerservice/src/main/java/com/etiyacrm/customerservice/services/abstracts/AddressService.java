package com.etiyacrm.customerservice.services.abstracts;

import com.etiyacrm.customerservice.core.business.paging.PageInfo;
import com.etiyacrm.customerservice.entities.Address;
import com.etiyacrm.customerservice.services.dtos.requests.address.CreateAddressRequest;
import com.etiyacrm.customerservice.services.dtos.requests.address.UpdateAddressRequest;
import com.etiyacrm.customerservice.services.dtos.responses.address.*;

import java.util.List;

public interface AddressService {
    CreatedAddressResponse add(CreateAddressRequest createAddressRequest);
    UpdatedAddressResponse update(long id, UpdateAddressRequest updateAddressRequest);
    Address findById(long id);
    DeletedAddressResponse delete(long id);
    List<GetAllAddressResponse> getAll();
    GetAddressResponse getById(long id);
    public List<GetAddressResponse> getByCustomerId(String customerId);
}
