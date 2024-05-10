package com.etiyacrm.customerservice.services.dtos.responses.address;

import com.etiyacrm.customerservice.entities.City;
import com.etiyacrm.customerservice.services.dtos.responses.city.CreatedCityResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreatedAddressResponse {
    private long id;
    private String description;
    private String street;
    private String houseFlatNumber;
    private int cityId;
    private int customerId;
    private String createdDate;
}
