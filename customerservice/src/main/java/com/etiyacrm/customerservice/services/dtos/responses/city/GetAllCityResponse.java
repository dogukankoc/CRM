package com.etiyacrm.customerservice.services.dtos.responses.city;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetAllCityResponse {
    private long id;
    private String name;

}
