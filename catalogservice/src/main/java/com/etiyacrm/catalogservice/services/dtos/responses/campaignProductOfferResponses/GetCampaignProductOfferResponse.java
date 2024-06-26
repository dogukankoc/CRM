package com.etiyacrm.catalogservice.services.dtos.responses.campaignProductOfferResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCampaignProductOfferResponse {
    private String id;
    private String productOfferId;
    private String campaignId;
}
