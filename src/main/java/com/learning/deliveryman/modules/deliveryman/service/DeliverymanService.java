package com.learning.deliveryman.modules.deliveryman.service;

import com.learning.deliveryman.modules.deliveryman.entity.Deliveryman;
import com.learning.deliveryman.modules.deliveryman.repository.DeliverymanRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeliverymanService {
    private final DeliverymanRepository deliverymanRepository;

    DeliverymanService(DeliverymanRepository deliverymanRepository) {
        this.deliverymanRepository = deliverymanRepository;
    }

    public Deliveryman save(Deliveryman deliveryman) throws Exception {
        Optional<Deliveryman> foundDeliverymanByEmail = this.deliverymanRepository.findByEmail(deliveryman.getEmail());
        if(foundDeliverymanByEmail.isPresent()) {
            throw new Exception("Email already exists");
        }

        Optional<Deliveryman> foundDeliverymanByDocument = this.deliverymanRepository.findByDocument(deliveryman.getDocument());
        if(foundDeliverymanByDocument.isPresent()) {
            throw new Exception("Document already exists");
        }

        return this.deliverymanRepository.save(deliveryman);
    };
}
