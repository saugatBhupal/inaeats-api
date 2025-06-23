package com.inaing.inaeats.utils.cloudinary.impl;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.inaing.inaeats.exception.exceptions.FileUploadException;
import com.inaing.inaeats.utils.cloudinary.CloudinaryUtil;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CloudinaryUtilImpl implements CloudinaryUtil {
    private final Cloudinary cloudinary;

    @Override
    public Map upload(MultipartFile file) {
        try {
            return (cloudinary.uploader().upload(file.getBytes(), Map.of()));
        } catch (IOException e) {
            throw new FileUploadException("Could not upload file");
        }
    }

}
