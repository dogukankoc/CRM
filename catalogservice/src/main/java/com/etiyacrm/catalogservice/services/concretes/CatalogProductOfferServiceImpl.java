package com.etiyacrm.catalogservice.services.concretes;

import com.etiyacrm.catalogservice.entities.CatalogProductOffer;
import com.etiyacrm.catalogservice.repositories.CatalogProductOfferRepository;
import com.etiyacrm.catalogservice.services.abstracts.CatalogProductOfferService;
import com.etiyacrm.catalogservice.services.dtos.requests.catalogProductOfferRequests.CreateCatalogProductOfferRequest;
import com.etiyacrm.catalogservice.services.dtos.requests.catalogProductOfferRequests.UpdateCatalogProductOfferRequest;
import com.etiyacrm.catalogservice.services.dtos.responses.catalogProductOfferResponses.*;
import com.etiyacrm.catalogservice.services.mappers.CatalogProductOfferMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CatalogProductOfferServiceImpl implements CatalogProductOfferService {
    private CatalogProductOfferRepository catalogProductOfferRepository;
    @Override
    public CreatedCatalogProductOfferResponse add(CreateCatalogProductOfferRequest createCatalogProductOfferRequest) {
        CatalogProductOffer catalogProductOffer =
                CatalogProductOfferMapper.INSTANCE.catalogProductOfferFromCreateCatalogProductOfferRequest(createCatalogProductOfferRequest);

        CatalogProductOffer createdCatalogProductOffer = catalogProductOfferRepository.save(catalogProductOffer);

        CreatedCatalogProductOfferResponse createdCatalogProductOfferResponse =
                CatalogProductOfferMapper.INSTANCE.createdCatalogProductOfferResponseFromCatalogProductOffer(createdCatalogProductOffer);

        return createdCatalogProductOfferResponse;
    }

    @Override
    public UpdatedCatalogProductOfferResponse update(UpdateCatalogProductOfferRequest updateCatalogProductOfferRequest, String id) {
        CatalogProductOffer catalogProductOffer =
                CatalogProductOfferMapper.INSTANCE.catalogProductOfferFromUpdateCatalogProductOfferRequest(updateCatalogProductOfferRequest);
        catalogProductOffer.setId(id);
        catalogProductOffer.setUpdatedDate(LocalDateTime.now());
        CatalogProductOffer updatedCatalogProductOffer = catalogProductOfferRepository.save(catalogProductOffer);

        UpdatedCatalogProductOfferResponse updatedCatalogProductOfferResponse =
                CatalogProductOfferMapper.INSTANCE.updatedCatalogProductOfferResponseFromCatalogProductOffer(updatedCatalogProductOffer);

        return updatedCatalogProductOfferResponse;
    }

    @Override
    public List<GetAllCatalogProductOfferResponse> getAll() {
        List<CatalogProductOffer> catalogProductOffers = catalogProductOfferRepository.findAll();

        List<GetAllCatalogProductOfferResponse> getAllCatalogProductOfferResponses = catalogProductOffers.stream()
                .map(CatalogProductOfferMapper.INSTANCE::getAllCatalogProductOfferResponseFromCatalogProductOffer)
                .collect(Collectors.toList());

        return getAllCatalogProductOfferResponses;
    }

    @Override
    public List<GetCatalogProductOfferResponse> finByProductOfferId(String id) {
        List<CatalogProductOffer> catalogProductOfferList = catalogProductOfferRepository.findByProductOfferId(id);

        List<GetCatalogProductOfferResponse> getCatalogProductOfferResponses =
                catalogProductOfferList.stream().map(CatalogProductOfferMapper.INSTANCE::getCatalogProductOfferResponseFromCatalogProductOffer)
                        .collect(Collectors.toList());
        return getCatalogProductOfferResponses;
    }

    @Override
    public DeletedCatalogProductOfferResponse delete(String id) {
        CatalogProductOffer catalogProductOffer = catalogProductOfferRepository.findById(id).get();
        catalogProductOffer.setId(id);
        catalogProductOffer.setDeletedDate(LocalDateTime.now());
        CatalogProductOffer deletedCatalogProductOffer = catalogProductOfferRepository.save(catalogProductOffer);

        DeletedCatalogProductOfferResponse deletedCatalogProductOfferResponse =
                CatalogProductOfferMapper.INSTANCE.deletedCatalogProductOfferResponseFromCatalogProductOffer(deletedCatalogProductOffer);

        return deletedCatalogProductOfferResponse;
    }
}
