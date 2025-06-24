package com.inaing.inaeats.dto.product;

import com.inaing.inaeats.entity.enums.DietType;
import com.inaing.inaeats.entity.enums.DifficultyType;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class MealKitCreationRequestDto {
    private String productName;
    private String productDescription;
    private Integer shelfLife;
    private Integer portion;
    private DietType dietType;
    private Integer weight;
    private Integer calories;
    private Integer fats;
    private Integer protein;
    private Integer carbs;
    private Integer duration;
    private DifficultyType difficulty;
}