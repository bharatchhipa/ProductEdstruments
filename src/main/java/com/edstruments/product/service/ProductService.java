package com.edstruments.product.service;

import com.edstruments.product.dto.ProductDto;
import com.edstruments.product.entity.Product;
import com.edstruments.product.exceptions.DataNotFoundException;
import com.edstruments.product.exceptions.DataValidationException;
import com.edstruments.product.repository.ProductRepository;
import com.edstruments.product.request.ProductCreateRequest;
import com.edstruments.product.request.ProductUpdateRequest;
import com.edstruments.product.response.ResponseWrapper;
import com.edstruments.product.wrapper.ResponseEntityWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class ProductService {

    private final ProductRepository productRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public ResponseEntity<ResponseWrapper> getAllProducts() {
        List<Product> products = productRepository.findAll();
        if(products.isEmpty()) {
            log.info("No products found");
            return ResponseEntityWrapper.successResponseBuilder("No products found");
        }
        List<ProductDto> productDtoList = products.stream()
                .map(product -> objectMapper.convertValue(product, ProductDto.class))
                .collect(Collectors.toList());
        return ResponseEntityWrapper.successResponseBuilder("Product list retrieved successfully", productDtoList);
    }

    public ResponseEntity<ResponseWrapper> getProductById(String id) {
        Optional<Product> productOptional = productRepository.findByUuid(id);
        if(!productOptional.isPresent()) {
            log.info("No product found with id {}", id);
            throw new DataNotFoundException("No product found with id " + id);
        }
        Product product = productOptional.get();
        ProductDto productDto = objectMapper.convertValue(product, ProductDto.class);

        return ResponseEntityWrapper.successResponseBuilder("Product retrieved successfully", productDto);

    }

    public ResponseEntity<ResponseWrapper> createProduct(ProductCreateRequest productRequest) {
        Optional<Product> existingProduct = productRepository.findByName(productRequest.getName());
        if(existingProduct.isPresent()) {
            log.info("Product already exists with name {}", productRequest.getName());
            return ResponseEntityWrapper.badRequestException("Product already exists with name " + productRequest.getName());
        }

        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .uuid(UUID.randomUUID().toString())
                .build();

        Product savedProduct = productRepository.save(product);
        ProductDto productDto = objectMapper.convertValue(savedProduct, ProductDto.class);
        return ResponseEntityWrapper.successResponseBuilder("Product created successfully",productDto);
    }

    public ResponseEntity<ResponseWrapper> updateProduct(String id, ProductUpdateRequest productUpdateRequest) {

        Optional<Product> existingProduct = productRepository.findByUuid(id);
        if(!existingProduct.isPresent()) {
            log.info("No product found with id {}", id);
            throw new DataNotFoundException("No product found with id " + id);
        }

        existingProduct.map(product -> {
            // Update only if the fields are not null
            if (productUpdateRequest.getName() != null) {
                // product name should be unique
                Optional<Product> existingProductByName =  productRepository.findByName(productUpdateRequest.getName());
                if(existingProductByName.isPresent()) {
                    throw new DataValidationException("Product with same name already exists" );
                }
                product.setName(productUpdateRequest.getName());
            }
            if (productUpdateRequest.getDescription() != null) {
                product.setDescription(productUpdateRequest.getDescription());
            }
            if (productUpdateRequest.getPrice() != null) {
                product.setPrice(productUpdateRequest.getPrice());
            }
            return productRepository.save(product);
        });
        log.info("Product updated successfully");

        return ResponseEntityWrapper.successResponseBuilder("Product updated successfully");

    }

    public ResponseEntity<ResponseWrapper> deleteProduct(String id) {
        Optional<Product> product = productRepository.findByUuid(id);
        if(!product.isPresent()) {
            log.info("No product found with id {}", id);
            throw new DataNotFoundException("No product found with id " + id);
        }
        productRepository.delete(product.get());

        return ResponseEntityWrapper.successResponseBuilder("Product deleted successfully");

    }
}