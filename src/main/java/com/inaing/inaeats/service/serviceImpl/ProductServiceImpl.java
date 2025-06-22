package com.inaing.inaeats.service.serviceImpl;

import org.springframework.stereotype.Service;

import com.inaing.inaeats.dto.product.MealKitCreationRequestDto;
import com.inaing.inaeats.entity.MealKit;
import com.inaing.inaeats.mapper.ProductMapper;
import com.inaing.inaeats.repository.ProductRepository;
import com.inaing.inaeats.service.ProductService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public String createMealKit(MealKitCreationRequestDto mealKitCreationRequestDto) {
        MealKit product = productMapper.toMealKit(mealKitCreationRequestDto);

        try {
            productRepository.save(product);
            return ("saved");
        } catch (Exception e) {
            return ("e");
        }

    }

}
