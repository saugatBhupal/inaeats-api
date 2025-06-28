package com.inaing.inaeats.dto.product;

import java.util.List;

import com.inaing.inaeats.entity.enums.DietType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class ProductDto {
    private String id;
    private String productName;
    private String productDescription;
    private Integer shelfLife;
    private Integer portion;
    private Integer price;
    private DietType dietType;
    private Integer weight;
    private Integer calories;
    private Integer fats;
    private Integer protein;
    private Integer carbs;
    private List<String> tags;
    private List<String> categories;
    private List<String> imageUrls;
    private List<String> allergens;
    private String productType;

}