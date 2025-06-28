package com.inaing.inaeats.dto.product.mealkit;

import com.inaing.inaeats.dto.product.ProductResponseDto;
import com.inaing.inaeats.entity.enums.DifficultyType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class MealKitResponseDto extends ProductResponseDto {
    private String recipeVideo;
    private Integer duration;
    private DifficultyType difficulty;
}
