package com.etiyacrm.catalogservice.services.concretes;

import com.etiyacrm.catalogservice.entities.Product;
import com.etiyacrm.catalogservice.repositories.ProductRepository;
import com.etiyacrm.catalogservice.services.abstracts.ProductService;
import com.etiyacrm.catalogservice.services.dtos.responses.productResponses.CreatedProductResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    @Override
    public CreatedProductResponse add() {
        Product product = new Product();
        productRepository.save(product);

        CreatedProductResponse createdProductResponse = new CreatedProductResponse();
        createdProductResponse.setId(product.getId());

        return createdProductResponse;
    }

}
