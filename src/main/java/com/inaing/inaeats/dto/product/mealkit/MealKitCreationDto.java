package com.inaing.inaeats.dto.product.mealkit;

import com.inaing.inaeats.dto.product.ProductCreationDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class MealKitCreationDto extends ProductCreationDto {
    private String recipeVideo;
    private Integer duration;
    private String difficulty;
}