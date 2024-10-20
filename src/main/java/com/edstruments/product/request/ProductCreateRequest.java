package com.edstruments.product.request;

import com.edstruments.product.constants.ValidationMessages;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductCreateRequest {
    @NotBlank(message = ValidationMessages.NAME_REQUIRED)
    @Size(min=2,max=100)
    private String name;
    @NotBlank(message = ValidationMessages.DESCRIPTION_REQUIRED)
    @Size(min=2,max=300)
    private String description;
    @NotNull(message = ValidationMessages.PRICE_REQUIRED)
    @Digits(integer = 2, fraction = 2)
    @DecimalMin(value = "0.00")
    private Double price;
}
