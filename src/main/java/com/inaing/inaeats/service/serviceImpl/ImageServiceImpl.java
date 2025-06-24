package com.inaing.inaeats.service.serviceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.inaing.inaeats.entity.Image;
import com.inaing.inaeats.entity.Product;
import com.inaing.inaeats.exception.exceptions.FileUploadException;
import com.inaing.inaeats.service.CloudinaryService;
import com.inaing.inaeats.service.ImageService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ImageServiceImpl implements ImageService {
    private final CloudinaryService cloudinaryService;

    @Override
    public List<Image> save(Product product, List<MultipartFile> files) {
        List<Image> images = new ArrayList<>();
        try {
            for (MultipartFile file : files) {
                String imageUrl = cloudinaryService.uploadFile(file, "inaeats/images");
                Image image = new Image();
                image.setUrl(imageUrl);
                image.setProduct(product);
                images.add(image);
            }
            return images;
        } catch (IOException exception) {
            throw new FileUploadException("Error uploading product image.");
        }
    }

    @Override
    public Image save(Product product, MultipartFile file) {
        try {
            String imageUrl = cloudinaryService.uploadFile(file, "inaeats/images");
            Image image = new Image();
            image.setUrl(imageUrl);
            image.setProduct(product);
            return image;
        } catch (IOException exception) {
            throw new FileUploadException("Error uploading product image.");
        }
    }

}
