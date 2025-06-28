package com.inaing.inaeats.service.serviceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

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
    private final ExecutorService executor;

    @Override
    public List<Image> save(Product product, List<MultipartFile> files) {
        List<Future<Image>> futureImages = new ArrayList<>();
        
        for (MultipartFile file : files) {
            futureImages.add(executor.submit(() -> {
                try {
                    String imageUrl = cloudinaryService.uploadFile(file, "inaeats/images");
                    Image image = new Image();
                    image.setUrl(imageUrl);
                    image.setProduct(product);
                    return image;
                } catch (IOException e) {
                    throw new FileUploadException("Failed to upload image: " + file.getOriginalFilename());
                }
            }));
        }
        List<Image> images = new ArrayList<>();
        for (Future<Image> future : futureImages) {
            try {
                images.add(future.get());
            } catch (InterruptedException | ExecutionException e) {
                throw new FileUploadException("Image upload failed");
            }
        }

        return images;
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
