package com.etiyacrm.catalogservice.services.concretes;

import com.etiyacrm.catalogservice.entities.Campaign;
import com.etiyacrm.catalogservice.repositories.CampaignRepository;
import com.etiyacrm.catalogservice.services.abstracts.CampaignService;
import com.etiyacrm.catalogservice.services.dtos.requests.campaignRequests.CreateCampaignRequest;
import com.etiyacrm.catalogservice.services.dtos.requests.campaignRequests.UpdateCampaignRequest;
import com.etiyacrm.catalogservice.services.dtos.responses.campaignResponses.*;
import com.etiyacrm.catalogservice.services.mappers.CampaignMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CampaignServiceImpl implements CampaignService {
    private CampaignRepository campaignRepository;

    @Override
    public CreatedCampaignResponse add(CreateCampaignRequest createCampaignRequest) {
        Campaign campaign =
                CampaignMapper.INSTANCE.campaignFromCreateCampaignRequest(createCampaignRequest);
        Campaign createdCampaign = campaignRepository.save(campaign);

        CreatedCampaignResponse createdCampaignResponse =
                CampaignMapper.INSTANCE.createdCampaignResponseFromCampaign(createdCampaign);

        return createdCampaignResponse;
    }

    @Override
    public UpdatedCampaignResponse update(UpdateCampaignRequest updateCampaignRequest, String id) {
        Campaign campaign =
                CampaignMapper.INSTANCE.campaignFromUpdateCampaignRequest(updateCampaignRequest);
        campaign.setId(id);
        campaign.setUpdatedDate(LocalDateTime.now());
        Campaign updatedCampaign = campaignRepository.save(campaign);

        UpdatedCampaignResponse updatedCapmaignResponse =
                CampaignMapper.INSTANCE.updatedCampaignResponseFromCampaign(updatedCampaign);

        return updatedCapmaignResponse;
    }

    @Override
    public List<GetAllCampaignResponse> getAll() {
        List<Campaign> campaignList = campaignRepository.findAll();
        List<GetAllCampaignResponse> getAllCampaignResponseList =
                campaignList.stream().map(CampaignMapper.INSTANCE::getAllCampaignResponseFromCampaign)
                        .collect(Collectors.toList());

        return getAllCampaignResponseList;
    }

    @Override
    public GetCampaignResponse getById(String id) {
        Campaign campaign = campaignRepository.findById(id).get();

        GetCampaignResponse getCampaignResponse =
                CampaignMapper.INSTANCE.getCampaignResponseFromCampaign(campaign);

        return getCampaignResponse;
    }

    @Override
    public DeletedCampaignResponse delete(String id) {
        Campaign campaign = campaignRepository.findById(id).get();
        campaign.setId(id);
        campaign.setDeletedDate(LocalDateTime.now());
        Campaign deletedCampaign = campaignRepository.save(campaign);

        DeletedCampaignResponse deletedCampaignResponse =
                CampaignMapper.INSTANCE.deletedCampaignResponseFromCampaign(deletedCampaign);

        return deletedCampaignResponse;

    }
}
