package com.icycodes.productservice.service;

import com.icycodes.productservice.entity.Product;
import com.icycodes.productservice.model.ProductRequest;
import com.icycodes.productservice.model.ProductResponse;

import java.util.List;

public interface ProductService {
    Long addProduct(ProductRequest productRequest);

    ProductResponse getProductById(Long productId);

    List<Product> getAllProducts();


    void reduceQuantity(Long productId, Long quantity);
}
