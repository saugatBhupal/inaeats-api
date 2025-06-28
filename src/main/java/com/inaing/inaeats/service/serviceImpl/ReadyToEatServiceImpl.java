package com.inaing.inaeats.service.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.inaing.inaeats.dto.product.ProductCreationDto;
import com.inaing.inaeats.dto.product.ProductResponseDto;
import com.inaing.inaeats.entity.Product;
import com.inaing.inaeats.service.ProductSubtypeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ReadyToEatServiceImpl implements ProductSubtypeService {

    @Override
    public ProductResponseDto create(ProductCreationDto productCreationRequestDto, List<MultipartFile> images) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public ProductResponseDto findProductById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findProductById'");
    }

    @Override
    public String getSupportedType() {
        return "ReadyToEat";
    }

    @Override
    public ProductResponseDto getProductOfInheritedEntitytype(Product product) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProductOfInheritedEntitytype'");
    }

}
