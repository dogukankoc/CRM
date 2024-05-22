package com.etiyacrm.catalogservice.controllers;

import com.etiyacrm.catalogservice.services.abstracts.CampaignService;
import com.etiyacrm.catalogservice.services.dtos.requests.campaignRequests.CreateCampaignRequest;
import com.etiyacrm.catalogservice.services.dtos.requests.campaignRequests.UpdateCampaignRequest;
import com.etiyacrm.catalogservice.services.dtos.responses.campaignResponses.*;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/campaigns")
public class CampaignController {
    private CampaignService campaignService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Add")
    public CreatedCampaignResponse add(@Valid @RequestBody CreateCampaignRequest createCampaignRequest){
        return campaignService.add(createCampaignRequest);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "getAll")
    public List<GetAllCampaignResponse> getAll(){
        return campaignService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "getById")
    public GetCampaignResponse getById(@PathVariable String id){
        return campaignService.getById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Update")
    public UpdatedCampaignResponse update(@Valid @RequestBody UpdateCampaignRequest updateCampaignRequest,
                                          @PathVariable String id){
        return campaignService.update(updateCampaignRequest, id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete")
    @ResponseStatus(HttpStatus.OK)
    public DeletedCampaignResponse delete(@PathVariable String id){
        return campaignService.delete(id);
    }

}
