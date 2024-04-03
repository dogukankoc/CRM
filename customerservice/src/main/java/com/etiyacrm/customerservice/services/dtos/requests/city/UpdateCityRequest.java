package com.etiyacrm.customerservice.services.dtos.requests.city;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateCityRequest {

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 30)
    private String name;
}
