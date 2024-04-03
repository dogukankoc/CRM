package com.etiyacrm.customerservice.services.dtos.responses.city;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeletedCityResponse {
    private long id;
    private LocalDateTime deletedDate;
}
