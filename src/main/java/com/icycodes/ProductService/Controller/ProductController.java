package com.icycodes.ProductService.Controller;

import com.icycodes.ProductService.Entity.Product;
import com.icycodes.ProductService.Model.ProductRequest;
import com.icycodes.ProductService.Model.ProductResponse;
import com.icycodes.ProductService.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Long> addProduct(@RequestBody ProductRequest productRequest){
        Long productId = productService.addProduct(productRequest);
        return new ResponseEntity<>(productId , HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable("id") Long productId){
        ProductResponse productResponse = productService.getProductById(productId);
        return new ResponseEntity<>(productResponse , HttpStatus.OK);
    }

    @GetMapping("/gimme")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

}
