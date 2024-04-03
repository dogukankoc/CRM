package com.etiyacrm.customerservice.services.concretes;

import com.etiyacrm.customerservice.core.business.paging.PageInfo;
import com.etiyacrm.customerservice.core.crossCusttingConcerns.types.BusinessException;
import com.etiyacrm.customerservice.entities.Address;
import com.etiyacrm.customerservice.repositories.AddressRepository;
import com.etiyacrm.customerservice.services.abstracts.AddressService;
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
    @Override
    public CreatedAddressResponse add(CreateAddressRequest createAddressRequest) {
        Address address = AddressMapper.INSTANCE.addressFromCreateAddressRequest(createAddressRequest);
        Address createdAddress = addressRepository.save(address);
        return AddressMapper.INSTANCE.createdAddressResponseFromAddress(createdAddress);
    }

    @Override
    public UpdatedAddressResponse update(long id, UpdateAddressRequest updateAddressRequest) {
        Address getCityById = findById(id);
        Address mappedAddress = AddressMapper.INSTANCE.addressFromUpdateAddressRequest((updateAddressRequest));
        mappedAddress.setCreatedDate(getCityById.getCreatedDate());
        mappedAddress.setId(id);
        Address updatedAddress = addressRepository.save(mappedAddress);
        return AddressMapper.INSTANCE.updatedAddressResponseFromAddress(updatedAddress);
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
