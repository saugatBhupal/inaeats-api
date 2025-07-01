package com.inaing.inaeats.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.inaing.inaeats.dto.product.ProductCreationDto;
import com.inaing.inaeats.dto.product.ProductResponseDto;

public interface ProductService {
    public ProductResponseDto create(ProductCreationDto productCreationRequestDto, List<MultipartFile> images);

    public ProductResponseDto findProductById(String id);

    public List<ProductResponseDto> searchProductByKeyword(String keyword);

    public List<ProductResponseDto> findAll();

}
