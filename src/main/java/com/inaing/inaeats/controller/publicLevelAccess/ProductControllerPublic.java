package com.inaing.inaeats.controller.publicLevelAccess;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inaing.inaeats.dto.product.ProductResponseDto;
import com.inaing.inaeats.response.RestStandardResponse;
import com.inaing.inaeats.service.ProductService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/product")
@AllArgsConstructor
public class ProductControllerPublic {
    private final ProductService productService;

    @GetMapping("/{productId}")
    public ResponseEntity<?> getProductById(@PathVariable("productId") String productId) {
        ProductResponseDto responseDto = productService.findProductById(productId);
        RestStandardResponse<ProductResponseDto> response = new RestStandardResponse<ProductResponseDto>(200,
                responseDto);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/search")
    public ResponseEntity<?> getMethodName(@RequestParam("keyword") String keyword) {
        List<ProductResponseDto> responseDto = productService.searchProductByKeyword(keyword);
        RestStandardResponse<List<ProductResponseDto>> response = new RestStandardResponse<List<ProductResponseDto>>(
                200,
                responseDto);
        return ResponseEntity.ok().body(response);
    }
}
