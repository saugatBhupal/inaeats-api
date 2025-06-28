package com.inaing.inaeats.controller.adminLevelAcess;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.inaing.inaeats.dto.product.ProductCreationDto;
import com.inaing.inaeats.dto.product.ProductResponseDto;
import com.inaing.inaeats.response.RestStandardResponse;
import com.inaing.inaeats.service.ProductService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/admin/product")
@AllArgsConstructor
public class ProductControllerAdmin {
    private final ProductService productService;

    @PostMapping(value = "/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> createProduct(@RequestPart("images") List<MultipartFile> images,
            @RequestPart("product") ProductCreationDto productDto) {
        ProductResponseDto response = productService.create(productDto, images);
        return ResponseEntity.ok().body(new RestStandardResponse<ProductResponseDto>(200, response));
    }

}
