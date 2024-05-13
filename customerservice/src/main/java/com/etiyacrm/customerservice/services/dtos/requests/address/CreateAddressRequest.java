package com.etiyacrm.customerservice.services.dtos.requests.address;

import com.etiyacrm.customerservice.entities.City;
import com.etiyacrm.customerservice.services.dtos.requests.city.CreateCityRequest;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateAddressRequest {
    @NotBlank(message = "Description cannot be null and only spaces")
    private String addressDescription;
    private String street;
    private String houseFlatNumber;
    private int cityId;
    private String customerId;
}
