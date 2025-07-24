package com.buyAndSell.server.controllers;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.buyAndSell.server.entities.Listing;
import com.buyAndSell.server.services.GCPCloudStorageService;
import com.buyAndSell.server.services.ListingService;
import com.buyAndSell.server.services.UserService;

@RestController
@RequestMapping("/api/listings")
public class ListingController {
    private final UserService userService;
    private final ListingService listingService;
    private final GCPCloudStorageService gcpCloudStorageService;

    public ListingController(UserService userService, ListingService listingService, GCPCloudStorageService gcpCloudStorageService) {
        this.userService = userService;
        this.listingService = listingService;
        this.gcpCloudStorageService = gcpCloudStorageService;
    }

    @PostMapping(path = "/create", consumes = "multipart/form-data", produces = "application/json")
    public ResponseEntity<Listing> createListing(@RequestParam("title") String title,
                                                 @RequestParam("description") String description,
                                                 @RequestParam("price") Double price,
                                                 @RequestParam("image") MultipartFile imageFile,
                                                 @RequestParam("createdBy") UUID createdById) {
        String imageUrl = gcpCloudStorageService.uploadImage(imageFile);
        Listing listing = Listing.builder()
                .title(title)
                .description(description)
                .price(price)
                .imageUrl(imageUrl)
                .createdBy(userService.findById(createdById))
                .build();
        Listing createdListing = listingService.createListing(listing);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdListing);
    }
}
