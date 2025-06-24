package com.inaing.inaeats.controller.admin_access;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.inaing.inaeats.dto.product.MealKitCreationRequestDto;
import com.inaing.inaeats.service.ProductService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/admin/product")
@AllArgsConstructor
public class MealKitController {
    private final ProductService productService;

    @PostMapping(value = "/create/meal-kit", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> createProduct(@RequestParam("images") List<MultipartFile> images,
            @ModelAttribute MealKitCreationRequestDto mealKitCreationRequestDto) {
        String res = productService.createMealKit(mealKitCreationRequestDto, images);
        return ResponseEntity.ok().body(res);
    }

}
