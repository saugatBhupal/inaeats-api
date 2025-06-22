package com.inaing.inaeats.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inaing.inaeats.dto.product.MealKitCreationRequestDto;
import com.inaing.inaeats.service.ProductService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/product")
@AllArgsConstructor
public class MealKitController {
    private final ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<?> createProduct(@RequestBody MealKitCreationRequestDto mealKitCreationRequestDto) {
        String res = productService.createMealKit(mealKitCreationRequestDto);
        return ResponseEntity.ok().body(res);
    }

}
