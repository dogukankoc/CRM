package com.etiyacrm.catalogservice.services.abstracts;

import com.etiyacrm.catalogservice.services.dtos.requests.campaignProductOfferRequests.CreateCampaignProductOfferRequest;
import com.etiyacrm.catalogservice.services.dtos.requests.campaignProductOfferRequests.UpdateCampaignProductOfferRequest;
import com.etiyacrm.catalogservice.services.dtos.responses.campaignProductOfferResponses.*;

import java.util.List;

public interface CampaignProductOfferService {
    CreatedCampaignProductOfferResponse add(CreateCampaignProductOfferRequest createCampaignProductOfferRequest);
    UpdatedCampaignProductOfferResponse update(UpdateCampaignProductOfferRequest updateCampaignProductOfferRequest, String id);
    List<GetAllCampaignProductOfferResponse> getAll();
    List<GetCampaignProductOfferResponse> findByProductOfferId(String id);
    DeletedCampaignProductOfferResponse delete(String id);

}
