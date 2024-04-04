package com.etiyacrm.customerservice.services.dtos.responses.city;

import com.etiyacrm.customerservice.services.dtos.responses.pagging.GetPageInfoResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetAllCityResponse {
    private List<GetCityResponse> getCityResponse;
    private GetPageInfoResponse getPageInfoResponse;
}
