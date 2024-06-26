package com.etiyacrm.customerservice.services.dtos.responses.address;

import com.etiyacrm.customerservice.entities.City;
import com.etiyacrm.customerservice.services.dtos.responses.city.GetCityResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetAddressResponse {
    private long id;
    private String addressDescription;
    private String street;
    private String houseFlatNumber;
    private String cityName;
    private int cityId;
    private String customerId;
}
