package com.inaing.inaeats.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.inaing.inaeats.dto.product.MealKitCreationRequestDto;

public interface ProductService {
    public String createMealKit(MealKitCreationRequestDto mealKitCreationRequestDto, List<MultipartFile> images);
}
