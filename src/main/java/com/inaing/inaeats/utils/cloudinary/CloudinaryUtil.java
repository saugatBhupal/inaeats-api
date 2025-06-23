package com.inaing.inaeats.utils.cloudinary;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface CloudinaryUtil {

    public Map upload(MultipartFile file);

}
