package com.buyAndSell.server.repositories;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.buyAndSell.server.entities.Listing;
import com.buyAndSell.server.entities.User;

public interface ListingRepository extends JpaRepository<Listing, UUID> {
    List<Listing> findByCreatedBy(User user);
}
