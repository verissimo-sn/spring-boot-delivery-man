package com.learning.deliveryman.modules.establishment.repository;

import com.learning.deliveryman.modules.establishment.entity.Establishment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstablishmentRepository extends MongoRepository<Establishment, String> {

    Optional<Establishment> findByEmail(String email);
    Optional<Establishment> findByDocument(int document);

}
