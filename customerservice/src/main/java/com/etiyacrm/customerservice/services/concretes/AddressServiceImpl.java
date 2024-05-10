package com.etiyacrm.customerservice.services.concretes;

import com.etiyacrm.customerservice.core.business.paging.PageInfo;
import com.etiyacrm.customerservice.core.crossCusttingConcerns.types.BusinessException;
import com.etiyacrm.customerservice.entities.Address;
import com.etiyacrm.customerservice.entities.City;
import com.etiyacrm.customerservice.entities.Customer;
import com.etiyacrm.customerservice.repositories.AddressRepository;
import com.etiyacrm.customerservice.services.abstracts.AddressService;
import com.etiyacrm.customerservice.services.abstracts.CityService;
import com.etiyacrm.customerservice.services.abstracts.CustomerService;
import com.etiyacrm.customerservice.services.dtos.requests.address.CreateAddressRequest;
import com.etiyacrm.customerservice.services.dtos.requests.address.UpdateAddressRequest;
import com.etiyacrm.customerservice.services.dtos.responses.address.*;
import com.etiyacrm.customerservice.services.mappers.AddressMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService {

    private AddressRepository addressRepository;
    private CustomerService customerService;
    private CityService cityService;
    @Override
    public CreatedAddressResponse add(CreateAddressRequest createAddressRequest) {
        Address mappedAddress = AddressMapper.INSTANCE.addressFromCreateAddressRequest(createAddressRequest);
        Customer customer = customerService.findById(createAddressRequest.getCustomerId());
        City city = cityService.findById(createAddressRequest.getCityId());
        mappedAddress.setCustomer(customer);
        mappedAddress.setCity(city);
        Address createdAddress = addressRepository.save(mappedAddress);
        CreatedAddressResponse createdAddressResponse = AddressMapper.INSTANCE.createdAddressResponseFromAddress(createdAddress);
        createdAddressResponse.setCustomerId(createAddressRequest.getCustomerId());
        createdAddressResponse.setCityId(createAddressRequest.getCityId());
        return createdAddressResponse;
    }

    @Override
    public UpdatedAddressResponse update(long id, UpdateAddressRequest updateAddressRequest) {
        Address getAddressById = findById(id);
        Address mappedAddress = AddressMapper.INSTANCE.addressFromUpdateAddressRequest((updateAddressRequest));
        mappedAddress.setId(id);
        mappedAddress.setCreatedDate(getAddressById.getCreatedDate());
        mappedAddress.setUpdatedDate(LocalDateTime.now());


        City city = cityService.findById(updateAddressRequest.getCityId());
        mappedAddress.setCity(city);
        mappedAddress.setCustomer(getAddressById.getCustomer());
        Address updatedAddress = addressRepository.save(mappedAddress);

        UpdatedAddressResponse updatedAddressResponse = AddressMapper.INSTANCE.updatedAddressResponseFromAddress(updatedAddress);
        return updatedAddressResponse;
    }

    @Override
    public DeletedAddressResponse delete(long id) {
        Address getAddressById = findById(id);
        getAddressById.setDeletedDate(LocalDateTime.now());
        Address deletedAddress = addressRepository.save(getAddressById);
        return AddressMapper.INSTANCE.deletedAddressResponseFromAddress(deletedAddress);
    }

    @Override
    public List<GetAllAddressResponse> getAll(PageInfo pageInfo) {
        Pageable pageable = PageRequest.of(pageInfo.getPage(),pageInfo.getSize());
        Page<Address> response = addressRepository.findAll(pageable);
        return response.stream().filter(address -> address.getDeletedDate() == null).map(address -> AddressMapper.INSTANCE.getAllAddressResponseFromAddress(address)).collect(Collectors.toList());
    }

    @Override
    public GetAddressResponse getById(long id) {
        Address getAddressById = findById(id);
        return AddressMapper.INSTANCE.getAddressResponseFromAddress(getAddressById);
    }

    @Override
    public Address findById(long id) {
        return addressRepository.findById(id).orElseThrow(() -> new BusinessException("Address not found"));
    }

}
