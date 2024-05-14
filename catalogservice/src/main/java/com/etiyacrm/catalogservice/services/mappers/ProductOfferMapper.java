package com.etiyacrm.catalogservice.services.mappers;

import com.etiyacrm.catalogservice.entities.ProductOffer;
import com.etiyacrm.catalogservice.services.dtos.requests.productOfferRequests.CreateProductOfferRequest;
import com.etiyacrm.catalogservice.services.dtos.requests.productOfferRequests.UpdateProductOfferRequest;
import com.etiyacrm.catalogservice.services.dtos.responses.productOfferResponses.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductOfferMapper {
    ProductOfferMapper INSTANCE = Mappers.getMapper(ProductOfferMapper.class);

    GetAllProductOfferResponse getAllProductOfferResponseFromProductOffer(ProductOffer productOffer);

    ProductOffer productOfferFromCreateProductOfferRequest(CreateProductOfferRequest createProductOfferRequest);

    CreatedProductOfferResponse createdProductOfferResponseFromProductOffer(ProductOffer productOffer);
    ProductOffer productOfferFromUpdateProductOfferRequest(UpdateProductOfferRequest updateProductOfferRequest);

    UpdatedProductOfferResponse updatedProductOfferResponseFromProductOffer(ProductOffer productOffer);
    DeletedProductOfferResponse deletedProductOfferResponseFromProductOffer(ProductOffer productOffer);

    GetProductOfferResponse getProductOfferResponseFromCProductOffer(ProductOffer productOffer);
}
