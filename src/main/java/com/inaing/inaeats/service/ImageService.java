package com.inaing.inaeats.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.inaing.inaeats.entity.Image;
import com.inaing.inaeats.entity.Product;

public interface ImageService {
    Image save(Product product, MultipartFile file);

    List<Image> save(Product product, List<MultipartFile> file);
}
