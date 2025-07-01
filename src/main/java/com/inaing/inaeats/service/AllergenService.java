package com.inaing.inaeats.service;

import java.util.List;

import com.inaing.inaeats.dto.allergen.AllergenCreationDto;
import com.inaing.inaeats.entity.Allergen;

public interface AllergenService {
    Allergen create(AllergenCreationDto allergenCreationDto);

    List<Allergen> findByNameOrId(List<String> allergens);
}
