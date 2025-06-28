package com.inaing.inaeats.mapper.mapperUtils;

import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import com.inaing.inaeats.entity.Category;
import com.inaing.inaeats.entity.Image;
import com.inaing.inaeats.entity.Tag;

@Component
public class ProductMappingUtils {

    @Named("tagListToNameList")
    public List<String> tagListToNameList(List<Tag> tags) {
        if (tags == null)
            return null;
        return tags.stream().map(Tag::getName).collect(Collectors.toList());
    }

    @Named("categoryListToNameList")
    public List<String> categoryListToNameList(List<Category> categories) {
        if (categories == null)
            return null;
        return categories.stream().map(Category::getName).collect(Collectors.toList());
    }

    @Named("imageListToUrlList")
    public List<String> imageListToUrlList(List<Image> images) {
        if (images == null)
            return null;
        return images.stream().map(Image::getUrl).collect(Collectors.toList());
    }
}