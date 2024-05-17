package com.etiyacrm.catalogservice.repositories;

import com.etiyacrm.catalogservice.entities.CampaignProductOffer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CampaignProductOfferRepository extends JpaRepository<CampaignProductOffer, String> {
    List<CampaignProductOffer> findByProductOfferId(String productOfferId);
}