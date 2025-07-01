package com.inaing.inaeats.service.serviceImpl;

import java.util.List;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Service;

import com.inaing.inaeats.dto.allergen.AllergenCreationDto;
import com.inaing.inaeats.entity.Allergen;
import com.inaing.inaeats.exception.exceptions.InternalServerException;
import com.inaing.inaeats.mapper.AllergenMapper;
import com.inaing.inaeats.repository.AllergenRepository;
import com.inaing.inaeats.service.AllergenService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AllergenServiceImpl implements AllergenService {
    private final AllergenRepository allergenRepository;
    private final AllergenMapper allergenMapper;

    @Override
    public Allergen create(AllergenCreationDto allergenCreationDto) {
        try {
            Allergen allergen = allergenMapper.toAllergen(allergenCreationDto);
            return allergenRepository.save(allergen);
        } catch (Exception e) {
            throw new InternalServerException("Error creating new allergen.");
        }
    }

    @Override
    public List<Allergen> findByNameOrId(List<String> allergens) {
        // List<Allergen> retrievedAllergens = allergenRepository.findAllById
        throw new NotImplementedException();
    }

}
