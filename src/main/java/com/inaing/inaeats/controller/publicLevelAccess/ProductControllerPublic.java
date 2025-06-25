package com.inaing.inaeats.controller.publicLevelAccess;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inaing.inaeats.dto.product.MealKitResponseDto;
import com.inaing.inaeats.response.RestStandardResponse;
import com.inaing.inaeats.service.ProductService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/product")
@AllArgsConstructor
public class ProductControllerPublic {

    @Qualifier("mealKitService")
    private final ProductService productService;

    @GetMapping("/{productId}")
    public ResponseEntity<?> getProductById(@PathVariable("productId") String productId) {
        MealKitResponseDto mealKitResponseDto = productService.findProductById(productId);
        RestStandardResponse<MealKitResponseDto> response = new RestStandardResponse<MealKitResponseDto>(200,
                mealKitResponseDto);
        return ResponseEntity.ok().body(response);
    }

}
