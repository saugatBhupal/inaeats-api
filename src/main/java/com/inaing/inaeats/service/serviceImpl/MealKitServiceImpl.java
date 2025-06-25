package com.inaing.inaeats.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.inaing.inaeats.dto.product.MealKitCreationRequestDto;
import com.inaing.inaeats.dto.product.MealKitResponseDto;
import com.inaing.inaeats.entity.Category;
import com.inaing.inaeats.entity.Image;
import com.inaing.inaeats.entity.MealKit;
import com.inaing.inaeats.entity.Tag;
import com.inaing.inaeats.exception.exceptions.ResourceNotFoundException;
import com.inaing.inaeats.mapper.ProductMapper;
import com.inaing.inaeats.repository.ProductRepository;
import com.inaing.inaeats.service.CategoryService;
import com.inaing.inaeats.service.ImageService;
import com.inaing.inaeats.service.ProductService;
import com.inaing.inaeats.service.TagService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Qualifier("mealKitService")
public class MealKitServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final ImageService imageService;
    private final TagService tagService;
    private final CategoryService categoryService;

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public String create(MealKitCreationRequestDto mealKitCreationRequestDto, List<MultipartFile> images) {
        MealKit product = productMapper.toMealKit(mealKitCreationRequestDto);
        try {
            List<Image> savedImages = imageService.save(product, images);
            List<Tag> tags = tagService.findOrCreateByName(mealKitCreationRequestDto.getTags());
            List<Category> categories = categoryService
                    .findExistingCategoriesByName(mealKitCreationRequestDto.getCategories());

            product.setImages(savedImages);
            product.setTags(tags);
            product.setCategories(categories);
            productRepository.save(product);
            return ("saved");
        } catch (Exception e) {
            return ("e");
        }
    }

    @Override
    public MealKitResponseDto findProductById(String id) {
        MealKit mealKit = (MealKit) productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found."));
        MealKitResponseDto responseDto = productMapper.toMealKitResponseDto(mealKit);
        responseDto.setTags(mealKit.getTags()
                .stream()
                .map(Tag::getName)
                .toList());
        responseDto.setCategories(mealKit.getCategories()
                .stream()
                .map(Category::getImage)
                .toList());
        responseDto.setImages(mealKit.getImages()
                .stream()
                .map(Image::getUrl)
                .toList());
        return responseDto;
    }

}
