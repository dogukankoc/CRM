package com.etiyacrm.catalogservice.services.dtos.responses.productResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatedProductResponse {
    private String id;
    private String name;
    private String description;
}
