package com.inaing.inaeats.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inaing.inaeats.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {

    @Query
    List<Category> findAllByNameInCategories(Set<String> categories);
}
