package com.inaing.inaeats.mapper;

import java.util.List;
import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.inaing.inaeats.dto.product.mealkit.MealKitCreationDto;
import com.inaing.inaeats.dto.product.mealkit.MealKitResponseDto;
import com.inaing.inaeats.entity.Category;
import com.inaing.inaeats.entity.Image;
import com.inaing.inaeats.entity.MealKit;
import com.inaing.inaeats.entity.Tag;
import com.inaing.inaeats.mapper.mapperUtils.ProductMappingUtils;

@Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE, uses = ProductMappingUtils.class)
public interface ProductMapper {

    @Mapping(target = "tags", ignore = true)
    @Mapping(target = "categories", ignore = true)
    MealKit toMealKit(MealKitCreationDto mealKitCreationDto);

    @Mapping(target = "tags", source = "tags", qualifiedByName = "tagListToNameList")
    @Mapping(target = "categories", source = "categories", qualifiedByName = "categoryListToNameList")
    @Mapping(target = "images", source = "images", qualifiedByName = "imageListToUrlList")
    MealKitResponseDto toProductDto(MealKit mealKit);

    @Named("tagSetToNameList")
    static List<String> tagSetToNameList(Set<Tag> tags) {
        if (tags == null)
            return null;
        return tags.stream()
                .map(Tag::getName)
                .toList();
    }

    @Named("categorySetToNameList")
    static List<String> categorySetToNameList(Set<Category> categories) {
        if (categories == null)
            return null;
        return categories.stream()
                .map(Category::getName)
                .toList();
    }

    @Named("imageSetToUrlList")
    static List<String> imageSetToUrlList(Set<Image> images) {
        if (images == null)
            return null;
        return images.stream()
                .map(Image::getUrl)
                .toList();
    }

}
