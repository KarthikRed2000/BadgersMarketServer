package com.buyAndSell.server.services;

import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.beans.factory.annotation.Value;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;

@Service
public class GCPCloudStorageService {
    private final Storage storage;

    @Value("${gcs.bucket.name}")
    private String bucketName;

    public GCPCloudStorageService(Storage storage) {
        this.storage = storage;
    }

    public String uploadImage(MultipartFile imageFile) {
        try {
            String fileName = UUID.randomUUID().toString() + "-" + imageFile.getOriginalFilename();
            BlobId blobId = BlobId.of(bucketName, fileName);
            BlobInfo blobInfo = BlobInfo.newBuilder(blobId)
                                .setContentType(imageFile.getContentType())
                                .build();
            storage.create(blobInfo, imageFile.getBytes());
            
            return "https://storage.googleapis.com/" + bucketName + "/" + fileName;
        } catch (IOException e) {
            throw new RuntimeException("Failed to upload image to GCP", e);
        }
    }
}
