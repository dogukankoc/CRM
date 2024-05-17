package com.etiyacrm.catalogservice.repositories;

import com.etiyacrm.catalogservice.entities.CatalogProductOffer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CatalogProductOfferRepository extends JpaRepository<CatalogProductOffer, String> {
    List<CatalogProductOffer> findByProductOfferId (String productOfferId);
}