package com.etiyacrm.catalogservice.services.mappers;

import com.etiyacrm.catalogservice.entities.Campaign;
import com.etiyacrm.catalogservice.services.dtos.requests.campaignRequests.CreateCampaignRequest;
import com.etiyacrm.catalogservice.services.dtos.requests.campaignRequests.UpdateCampaignRequest;
import com.etiyacrm.catalogservice.services.dtos.responses.campaignResponses.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CampaignMapper {
    CampaignMapper INSTANCE = Mappers.getMapper(CampaignMapper.class);
    GetAllCampaignResponse getAllCampaignResponseFromCampaign(Campaign campaign);
    Campaign campaignFromCreateCampaignRequest(CreateCampaignRequest createCampaignRequest);
    CreatedCampaignResponse createdCampaignResponseFromCampaign(Campaign campaign);
    Campaign campaignFromUpdateCampaignRequest(UpdateCampaignRequest updateCampaignRequest);
    UpdatedCampaignResponse updatedCampaignResponseFromCampaign(Campaign campaign);
    DeletedCampaignResponse deletedCampaignResponseFromCampaign(Campaign campaign);
    GetCampaignResponse getCampaignResponseFromCampaign(Campaign campaign);

}
