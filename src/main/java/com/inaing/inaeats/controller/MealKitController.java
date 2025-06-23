package com.inaing.inaeats.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.inaing.inaeats.dto.product.MealKitCreationRequestDto;
import com.inaing.inaeats.service.ProductService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/product")
@AllArgsConstructor
public class MealKitController {
    private final ProductService productService;

    // @Secured({ "ROLE_ADMIN" })
    @PostMapping("/create/meal-kit")
    public ResponseEntity<?> createProduct(@RequestParam("images") List<MultipartFile> images,
            @RequestPart("product") MealKitCreationRequestDto mealKitCreationRequestDto) {
        String res = productService.createMealKit(mealKitCreationRequestDto);
        System.out.println(images.size());
        return ResponseEntity.ok().body(res);
    }

}
