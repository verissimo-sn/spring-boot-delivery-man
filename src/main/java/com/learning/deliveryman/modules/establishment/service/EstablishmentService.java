package com.learning.deliveryman.modules.establishment.service;

import com.learning.deliveryman.modules.establishment.entity.Establishment;
import com.learning.deliveryman.modules.establishment.repository.EstablishmentRepository;
import org.springframework.stereotype.Service;

@Service
public class EstablishmentService {
    private final EstablishmentRepository establishmentRepository;

    EstablishmentService(EstablishmentRepository establishmentRepository) {
        this.establishmentRepository = establishmentRepository;
    }

    public Establishment save(Establishment establishment) {
        return this.establishmentRepository.save(establishment);
    }
}
