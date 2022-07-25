package com.learning.deliveryman.modules.deliveryman.repository;

import com.learning.deliveryman.modules.deliveryman.entity.Deliveryman;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeliverymanRepository extends MongoRepository<Deliveryman, String> {
    Optional<Deliveryman> findByEmail(String email);
    Optional<Deliveryman> findByDocument(Integer document);

}
