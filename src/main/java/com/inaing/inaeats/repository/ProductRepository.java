package com.inaing.inaeats.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inaing.inaeats.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

}
