package com.learning.deliveryman.modules.establishment.repository;

import com.learning.deliveryman.modules.establishment.entity.Establishment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstablishmentRepository extends MongoRepository<Establishment, String> {
}
