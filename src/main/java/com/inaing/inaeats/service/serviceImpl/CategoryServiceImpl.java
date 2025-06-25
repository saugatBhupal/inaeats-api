package com.inaing.inaeats.service.serviceImpl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.inaing.inaeats.entity.Category;
import com.inaing.inaeats.repository.CategoryRepository;
import com.inaing.inaeats.service.CategoryService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findExistingCategoriesByName(List<String> categories) {

        Set<String> distinctNames = categories.stream()
                .map(String::trim)
                .filter(name -> !name.isEmpty())
                .collect(Collectors.toSet());

        List<Category> exisitingCategories = categoryRepository.findAllByNameIn(distinctNames);

        return exisitingCategories;

    }

}
