package com.inaing.inaeats.dto.product.mealkit;

import com.inaing.inaeats.dto.product.ProductDto;
import com.inaing.inaeats.entity.enums.DifficultyType;

public class MealKitDto extends ProductDto {
    private String recipeVideo;
    private Integer duration;
    private DifficultyType difficulty;
}
