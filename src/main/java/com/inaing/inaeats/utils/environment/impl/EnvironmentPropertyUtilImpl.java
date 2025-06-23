package com.inaing.inaeats.utils.environment.impl;

import java.util.HashMap;
import java.util.Map;

import com.inaing.inaeats.config.EnvironmentPropertyConfig;
import com.inaing.inaeats.utils.environment.EnvironmentPropertyUtil;

public class EnvironmentPropertyUtilImpl implements EnvironmentPropertyUtil {

    @Override
    public Map<String, Object> getCloudinaryConfig() {
        Map<String, Object> cloudinaryConfig = new HashMap<String, Object>();
        cloudinaryConfig.put("cloud_name", EnvironmentPropertyConfig.getProperty("cloudinary.cloud.name"));
        cloudinaryConfig.put("api_key", EnvironmentPropertyConfig.getProperty("cloudinary.api.key"));
        cloudinaryConfig.put("api_secret", EnvironmentPropertyConfig.getProperty("cloudinary.api.secret"));
        cloudinaryConfig.put("secure",
                Boolean.parseBoolean(EnvironmentPropertyConfig.getProperty("cloudinary.secure")));
        return cloudinaryConfig;
    }

}
