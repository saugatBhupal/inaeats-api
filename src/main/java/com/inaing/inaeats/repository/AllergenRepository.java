package com.inaing.inaeats.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inaing.inaeats.entity.Allergen;

@Repository
public interface AllergenRepository extends JpaRepository<Allergen, String> {

    @Query
    List<Allergen> findAllByNameIn(Set<String> names);
}
