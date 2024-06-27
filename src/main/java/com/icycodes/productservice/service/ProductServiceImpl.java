package com.icycodes.productservice.service;

import com.icycodes.productservice.entity.Product;
import com.icycodes.productservice.entity.ProductRepository;
import com.icycodes.productservice.exceptions.InappropriateQuantityException;
import com.icycodes.productservice.exceptions.ProductNotFoundException;
import com.icycodes.productservice.model.ProductRequest;
import com.icycodes.productservice.model.ProductResponse;
import lombok.extern.log4j.Log4j2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

import static org.springframework.beans.BeanUtils.copyProperties;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService{


    @Autowired
    private ProductRepository productRepository;


    @Override
    public Long addProduct(ProductRequest productRequest) {
        log.info("adding product start");

        Product product = Product.builder()
                .productName(productRequest.getName())
                .price(productRequest.getPrice())
                .quantity(productRequest.getQuantity())
                .build();
        log.info("product obj created");
        System.out.println(product);

        productRepository.save(product);

        log.info("product saved in database");
        log.info(product.getProductId());
        return product.getProductId();
    }

    @Override
    public ProductResponse getProductById(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(
                        ()-> new ProductNotFoundException(" product not found", "PRODUCT_NOT_FOUND")
                );

        log.info("product found");

        ProductResponse productResponse = new ProductResponse();
        copyProperties(product , productResponse);

        return productResponse;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> productList = productRepository.findAll();
        return productList;
    }


    @Override
    public void reduceQuantity(Long productId,Long quantity){

        log.info("reducing quantity started");

        Product product = productRepository.findById(productId)
                .orElseThrow(
                        ()-> new ProductNotFoundException(" product not found", "PRODUCT_NOT_FOUND")
                );

        log.info("product found to reduce quantity");

        if(product.getQuantity()<quantity){

            log.info("ordered quantity is more than inventory");

            throw new InappropriateQuantityException(
                    "ordered quantity is more than inventory" ,
                    "INSUFFICIENT_QUANTITY"
            );
        }


        product.setQuantity(product.getQuantity() - quantity);
        log.info(" quantity is reduced");

        productRepository.save(product);
        log.info(" product updated after reducing quantity");



    }
}
