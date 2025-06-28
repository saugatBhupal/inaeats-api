package com.inaing.inaeats.service.serviceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.inaing.inaeats.dto.product.ProductCreationDto;
import com.inaing.inaeats.dto.product.ProductResponseDto;
import com.inaing.inaeats.entity.Product;
import com.inaing.inaeats.factory.ProductSubtypeServiceFactory;
import com.inaing.inaeats.repository.ProductRepository;
import com.inaing.inaeats.service.ProductService;
import com.inaing.inaeats.service.ProductSubtypeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductSubtypeServiceFactory productSubtypeServiceFactory;

    @Override
    public ProductResponseDto create(ProductCreationDto productCreationRequestDto, List<MultipartFile> images) {
        ProductSubtypeService productSubtypeService = productSubtypeServiceFactory
                .getSubtypeService(productCreationRequestDto
                        .getProductType());
        return productSubtypeService.create(productCreationRequestDto, images);
    }

    private List<ProductResponseDto> findAllById(List<String> ids) {
        List<Product> products = productRepository.findAllById(ids);
        List<ProductResponseDto> productDtos = new ArrayList<>();
        for (Product product : products) {
            productDtos.add(productSubtypeServiceFactory.getSubtypeService(product.getProductType())
                    .getProductOfInheritedEntitytype(product));
        }
        return productDtos;
    }

    @Override
    public ProductResponseDto findProductById(String id) {
        Product product = productRepository.findById(id).get();
        ProductSubtypeService productSubtypeService = productSubtypeServiceFactory
                .getSubtypeService(product.getProductType());
        return productSubtypeService.getProductOfInheritedEntitytype(product);
    }

    @Override
    public List<ProductResponseDto> searchProductByKeyword(String keyword) {
        String tsQuery = Arrays.stream(keyword.trim()
                .split("\\s+"))
                .map(term -> term + ":*")
                .collect(Collectors.joining("&"));
        List<String> matchingProductIdsWithScore = productRepository.searchProducts(tsQuery);
        List<String> matchingProductIds = matchingProductIdsWithScore.stream()
                .map(id -> id.split(",")[0])
                .toList();
        List<ProductResponseDto> results = findAllById(matchingProductIds);
        return results;
    }

}
