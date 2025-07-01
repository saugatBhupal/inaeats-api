package com.inaing.inaeats.controller.adminLevelAcess;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inaing.inaeats.dto.allergen.AllergenCreationDto;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/admin/allergen")
public class AllergenControllerAdmin {

    @PostMapping("/")
    public ResponseEntity<?> createAllergen(@RequestBody AllergenCreationDto allergenCreationDto) {

        return ResponseEntity.ok().body("null");
    }

}
