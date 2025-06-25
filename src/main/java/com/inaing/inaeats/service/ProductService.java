package com.inaing.inaeats.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.inaing.inaeats.dto.product.MealKitCreationRequestDto;
import com.inaing.inaeats.dto.product.MealKitResponseDto;

public interface ProductService {
    public String create(MealKitCreationRequestDto mealKitCreationRequestDto, List<MultipartFile> images);

    public MealKitResponseDto findProductById(String id);
}
