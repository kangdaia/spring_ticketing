package com.study_spring.ticketing.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Configuration
public class KOPISDataConfig {

    @Value("${kospi.baseUrl.prfplc}")
    private String prfplcBaseUrl;

    @Bean
    public WebClient prfplcWebClient() {
        DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory(prfplcBaseUrl);
        factory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.VALUES_ONLY);
        return WebClient
                .builder()
                .uriBuilderFactory(factory)
                .baseUrl(prfplcBaseUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_XML_VALUE)
                .build();
    }

}
