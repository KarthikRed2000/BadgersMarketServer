package com.buyAndSell.server.services;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.buyAndSell.server.entities.Listing;
import com.buyAndSell.server.repositories.ListingRepository;

@Service
public class ListingService {
    private final ListingRepository listingRepository;

    public ListingService(ListingRepository listingRepository) {
        this.listingRepository = listingRepository;
    }

    public Listing createListing(Listing listing) {
        if (listing.getCreatedAt() == null) {
            listing.setCreatedAt(LocalDateTime.now());
        }
        return listingRepository.save(listing);
    }
}
