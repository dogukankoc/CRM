package com.etiyacrm.catalogservice.services.abstracts;

import com.etiyacrm.catalogservice.services.dtos.requests.productOfferRequests.CreateProductOfferRequest;
import com.etiyacrm.catalogservice.services.dtos.requests.productOfferRequests.UpdateProductOfferRequest;
import com.etiyacrm.catalogservice.services.dtos.responses.productOfferResponses.*;

import java.util.List;

public interface ProductOfferService {
    CreatedProductOfferResponse add(CreateProductOfferRequest createProductOfferRequest);
    UpdatedProductOfferResponse update(UpdateProductOfferRequest updateProductOfferRequest, String id);
    List<GetAllProductOfferResponse> getAll();
    GetProductOfferResponse getById(String id);
    DeletedProductOfferResponse delete(String id);
}
