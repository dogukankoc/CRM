package com.etiyacrm.catalogservice.services.abstracts;

import com.etiyacrm.catalogservice.services.dtos.requests.campaignRequests.CreateCampaignRequest;
import com.etiyacrm.catalogservice.services.dtos.requests.campaignRequests.UpdateCampaignRequest;
import com.etiyacrm.catalogservice.services.dtos.responses.campaignResponses.*;

import java.util.List;

public interface CampaignService {
    CreatedCampaignResponse add(CreateCampaignRequest createCampaignRequest);
    UpdatedCampaignResponse update(UpdateCampaignRequest updateCampaignRequest, String id);
    List<GetAllCampaignResponse> getAll();
    GetCampaignResponse getById(String id);
    DeletedCampaignResponse delete(String id);
}
