package com.inaing.inaeats.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inaing.inaeats.entity.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, String> {

}
