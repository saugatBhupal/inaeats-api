package com.inaing.inaeats.service;

import java.util.List;

import com.inaing.inaeats.entity.Category;

public interface CategoryService {
    List<Category> findExistingCategoriesByName(List<String> categories);
}
