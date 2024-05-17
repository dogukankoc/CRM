package com.etiyacrm.catalogservice.services.dtos.requests.characteristicValueRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCharacteristicValueRequest {
    private String value;
    private boolean isActive;
    private String characteristicId;
}
