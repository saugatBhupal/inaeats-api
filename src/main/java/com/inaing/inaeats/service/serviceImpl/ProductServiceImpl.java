package com.inaing.inaeats.service.serviceImpl;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.inaing.inaeats.dto.product.MealKitCreationRequestDto;
import com.inaing.inaeats.entity.Image;
import com.inaing.inaeats.entity.MealKit;
import com.inaing.inaeats.mapper.ProductMapper;
import com.inaing.inaeats.repository.ProductRepository;
import com.inaing.inaeats.service.ImageService;
import com.inaing.inaeats.service.ProductService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final ImageService imageService;

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public String createMealKit(MealKitCreationRequestDto mealKitCreationRequestDto, List<MultipartFile> images) {
        MealKit product = productMapper.toMealKit(mealKitCreationRequestDto);
        try {
            List<Image> savedImages = imageService.save(product, images);
            product.setImages(savedImages);
            productRepository.save(product);
            return ("saved");
        } catch (Exception e) {
            return ("e");
        }

    }

}
