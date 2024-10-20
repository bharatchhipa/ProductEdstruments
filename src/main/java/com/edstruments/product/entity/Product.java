package com.edstruments.product.entity;


import com.edstruments.product.entity.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product extends BaseEntity {
    private String name;
    private String description;
    private Double price;
    private String uuid;
}
