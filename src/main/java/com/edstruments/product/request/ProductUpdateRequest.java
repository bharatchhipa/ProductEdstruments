package com.edstruments.product.request;

import com.edstruments.product.constants.ValidationMessages;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;


@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductUpdateRequest {

    @Size(min=2,max=100)
    private String name;

    @Size(min=2,max=300)
    private String description;

    @Digits(integer = 2, fraction = 2)
    @DecimalMin(value = "0.00")
    private Double price;
}
