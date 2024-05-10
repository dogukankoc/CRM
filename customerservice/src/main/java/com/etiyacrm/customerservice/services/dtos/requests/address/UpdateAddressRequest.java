package com.etiyacrm.customerservice.services.dtos.requests.address;

import com.etiyacrm.customerservice.entities.City;
import com.etiyacrm.customerservice.services.dtos.requests.city.UpdateCityRequest;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateAddressRequest {
    @NotBlank(message = "Description cannot be null and only spaces")
    private String description;
    private String street;
    private String houseFlatNumber;
    @NotBlank(message = "City cannot be null and only spaces")
    private int cityId;
}
