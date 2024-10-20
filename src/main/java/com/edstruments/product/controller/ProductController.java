package com.edstruments.product.controller;

import com.edstruments.product.entity.Product;
import com.edstruments.product.request.ProductCreateRequest;
import com.edstruments.product.request.ProductUpdateRequest;
import com.edstruments.product.response.ResponseWrapper;
import com.edstruments.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<ResponseWrapper> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseWrapper> getProductById(@PathVariable String id) {
        return productService.getProductById(id);

    }

    @PostMapping
    public ResponseEntity<ResponseWrapper> createProduct(@Valid @RequestBody ProductCreateRequest product) {
        return productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseWrapper> updateProduct(@PathVariable String id,@Valid  @RequestBody ProductUpdateRequest product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseWrapper> deleteProduct(@PathVariable String id) {
        return productService.deleteProduct(id);
    }
}
