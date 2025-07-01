package com.inaing.inaeats.mapper;

import org.mapstruct.Mapper;

import com.inaing.inaeats.dto.allergen.AllergenCreationDto;
import com.inaing.inaeats.entity.Allergen;

@Mapper(componentModel = "Spring")
public interface AllergenMapper {
    Allergen toAllergen(AllergenCreationDto allergenCreationDto);
}
