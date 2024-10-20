package com.edstruments.product.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductDto {
    private String name;
    private String description;
    private BigDecimal price;
    private String uuid;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    private Date createdOn;
}
