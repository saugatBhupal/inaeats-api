package com.inaing.inaeats.mapper;

import org.mapstruct.Mapper;

import com.inaing.inaeats.dto.product.MealKitCreationRequestDto;
import com.inaing.inaeats.entity.MealKit;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    MealKit toMealKit(MealKitCreationRequestDto mealKitCreationRequestDto);
}
