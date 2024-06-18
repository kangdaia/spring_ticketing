package com.study_spring.ticketing.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "api.kopis")
public class APIConfig {
    private String key;
    private String baseurl;

    // getter and setter
    public String getKey() {
        return key;
    }
    
    public String getBaseurl() {
        return baseurl;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setBaseurl(String baseurl) {
        this.baseurl = baseurl;
    }
}