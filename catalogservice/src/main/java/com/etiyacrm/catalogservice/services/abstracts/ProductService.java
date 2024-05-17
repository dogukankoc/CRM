package com.etiyacrm.catalogservice.services.abstracts;

import com.etiyacrm.catalogservice.services.dtos.requests.productRequests.CreateProductRequest;
import com.etiyacrm.catalogservice.services.dtos.requests.productRequests.UpdateProductRequest;
import com.etiyacrm.catalogservice.services.dtos.responses.productResponses.*;

import java.util.List;

public interface ProductService {
    CreatedProductResponse add(CreateProductRequest createProductRequest);
    UpdatedProductResponse update(UpdateProductRequest updateProductRequest, String id);
    DeletedProductResponse delete(String id);
    List<GetAllProductResponse> getAll();
    GetProductResponse getById(String id);


}