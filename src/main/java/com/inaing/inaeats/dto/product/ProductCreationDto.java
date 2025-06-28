package com.inaing.inaeats.dto.product;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.inaing.inaeats.dto.product.mealkit.MealKitCreationDto;
import com.inaing.inaeats.dto.product.readyToEat.ReadyToEatCreationDto;
import com.inaing.inaeats.entity.enums.DietType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "productType", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = MealKitCreationDto.class, name = "MealKit"),
        @JsonSubTypes.Type(value = ReadyToEatCreationDto.class, name = "ReadyToEat")
})
@AllArgsConstructor
@NoArgsConstructor
@Data
public abstract class ProductCreationDto {
    private String productName;
    private String productDescription;
    private Integer shelfLife;
    private Integer portion;
    private DietType dietType;
    private String productType;
    private Integer price;
    private Integer weight;
    private Integer calories;
    private Integer fats;
    private Integer protein;
    private Integer carbs;
    private List<String> tags;
    private List<String> categories;
}