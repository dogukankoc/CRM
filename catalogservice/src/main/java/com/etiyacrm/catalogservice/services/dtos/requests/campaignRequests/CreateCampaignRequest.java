package com.etiyacrm.catalogservice.services.dtos.requests.campaignRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCampaignRequest {
    private String name;
    private String description;
    private String code;
}
