package com.etiyacrm.customerservice.services.dtos.responses.address;

import com.etiyacrm.customerservice.entities.City;
import com.etiyacrm.customerservice.services.dtos.responses.city.UpdatedCityResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdatedAddressResponse {

    private long id;
    private String description;
    private String street;
    private String houseFlatNumber;
    private int cityId;
    private int customerId;
    private LocalDateTime updatedDate;
}
