package com.inaing.inaeats.factory;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inaing.inaeats.service.ProductSubtypeService;

@Service
public class ProductSubtypeServiceFactory {
    private final Map<String, ProductSubtypeService> productSubtypeServices;

    @Autowired
    public ProductSubtypeServiceFactory(ObjectProvider<ProductSubtypeService> servicesProvider) {
        this.productSubtypeServices = servicesProvider.stream()
                .collect(Collectors.toMap(
                        ProductSubtypeService::getSupportedType,
                        Function.identity()));
    }

    public ProductSubtypeService getSubtypeService(String productType) {
        ProductSubtypeService service = productSubtypeServices.get(productType);
        if (service == null) {
            throw new IllegalArgumentException("Unsupported product type: " + productType);
        }
        return service;
    }
}