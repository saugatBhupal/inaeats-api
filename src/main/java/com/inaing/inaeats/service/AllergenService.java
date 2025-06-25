package com.inaing.inaeats.service;

import java.util.List;

import com.inaing.inaeats.entity.Allergen;

public interface AllergenService {
    List<Allergen> findOrCreateByName(List<String> allergens);
}
