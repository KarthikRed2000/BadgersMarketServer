package com.buyAndSell.server.configurations;

import java.io.FileInputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

@Configuration
public class GCSConfig {
    @Value("${gcp.credentials.path}")
    private String credentialPath;

    @Bean
    public Storage storage() throws IOException{
        return StorageOptions.newBuilder()
                .setCredentials(ServiceAccountCredentials.fromStream(new FileInputStream(credentialPath)))
                .build()
                .getService();
    }
}
