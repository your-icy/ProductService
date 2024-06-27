package com.icycodes.ProductService.Service;

import com.icycodes.ProductService.Entity.Product;
import com.icycodes.ProductService.Model.ProductRequest;
import com.icycodes.ProductService.Model.ProductResponse;

import java.util.List;

public interface ProductService {
    Long addProduct(ProductRequest productRequest);

    ProductResponse getProductById(Long productId);

    List<Product> getAllProducts();
}
