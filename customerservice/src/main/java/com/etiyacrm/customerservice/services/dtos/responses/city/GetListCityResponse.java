package com.etiyacrm.customerservice.services.dtos.responses.city;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListCityResponse {
    private int id;
    private String name;
}