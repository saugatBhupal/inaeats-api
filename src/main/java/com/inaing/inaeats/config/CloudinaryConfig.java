package com.inaing.inaeats.config;

import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.inaing.inaeats.utils.environment.EnvironmentPropertyUtil;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class CloudinaryConfig {
    private final EnvironmentPropertyUtil environmentPropertyUtil;

    @Bean
    public Cloudinary getCloudinary() {
        Map<String, Object> config = environmentPropertyUtil.getCloudinaryConfig();
        return new Cloudinary(config);
    }
}