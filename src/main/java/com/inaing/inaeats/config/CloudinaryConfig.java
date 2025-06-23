package com.inaing.inaeats.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.inaing.inaeats.utils.environment.environmentProperty.CloudinaryProperty;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class CloudinaryConfig {
    private final CloudinaryProperty cloudinaryProperty;

    @Bean
    public Cloudinary cloudinary() {
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", cloudinaryProperty.getCloudName(),
                "api_key", cloudinaryProperty.getApiKey(),
                "api_secret", cloudinaryProperty.getApiSecret()));
    }
}