package com.inaing.inaeats.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.inaing.inaeats.dto.product.MealKitCreationRequestDto;
import com.inaing.inaeats.entity.MealKit;

@Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface ProductMapper {

    @Mapping(target = "tags", ignore = true)
    @Mapping(target = "categories", ignore = true)
    MealKit toMealKit(MealKitCreationRequestDto mealKitCreationRequestDto);
}
