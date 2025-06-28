package com.inaing.inaeats.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.inaing.inaeats.dto.product.ProductCreationDto;
import com.inaing.inaeats.dto.product.ProductResponseDto;
import com.inaing.inaeats.dto.product.mealkit.MealKitCreationDto;
import com.inaing.inaeats.entity.Category;
import com.inaing.inaeats.entity.Image;
import com.inaing.inaeats.entity.MealKit;
import com.inaing.inaeats.entity.Product;
import com.inaing.inaeats.entity.Tag;
import com.inaing.inaeats.mapper.ProductMapper;
import com.inaing.inaeats.repository.ProductRepository;
import com.inaing.inaeats.service.CategoryService;
import com.inaing.inaeats.service.ImageService;
import com.inaing.inaeats.service.ProductSubtypeService;
import com.inaing.inaeats.service.TagService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Qualifier("mealKitService")
public class MealKitServiceImpl implements ProductSubtypeService {
    private ProductMapper productMapper;
    private CategoryService categoryService;
    private ImageService imageService;
    private TagService tagService;
    private ProductRepository productRepository;

    @Override
    public ProductResponseDto create(ProductCreationDto productCreationDto, List<MultipartFile> images) {
        MealKit mealKit = productMapper.toMealKit((MealKitCreationDto) productCreationDto);
        List<Image> savedImages = imageService.save(mealKit, images);
        List<Tag> tags = tagService.findOrCreateByName(productCreationDto.getTags());
        List<Category> categories = categoryService
                .findExistingCategoriesByName(productCreationDto.getCategories());
        mealKit.setImages(savedImages);
        mealKit.setTags(tags);
        mealKit.setCategories(categories);
        MealKit savedKit = productRepository.save(mealKit);
        return productMapper.toProductDto(savedKit);
    }

    @Override
    public String getSupportedType() {
        return "MealKit";
    }

    @Override
    public ProductResponseDto findProductById(String id) {
        /* Already implemented in parent entity service */
        throw new UnsupportedOperationException("Unimplemented method 'findProductById'");
    }

    @Override
    public ProductResponseDto getProductOfInheritedEntitytype(Product product) {
        return productMapper.toProductDto((MealKit) product);
    }

}
