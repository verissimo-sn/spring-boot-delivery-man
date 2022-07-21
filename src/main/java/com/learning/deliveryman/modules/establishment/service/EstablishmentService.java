package com.learning.deliveryman.modules.establishment.service;

import com.learning.deliveryman.modules.establishment.entity.Establishment;
import com.learning.deliveryman.modules.establishment.repository.EstablishmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class EstablishmentService {
    private final EstablishmentRepository establishmentRepository;

    EstablishmentService(EstablishmentRepository establishmentRepository) {
        this.establishmentRepository = establishmentRepository;
    }

    @Transactional
    public Establishment save(Establishment establishment) throws Exception{
        Optional<Establishment> foundEstablishmentByEmail = this.establishmentRepository.findByEmail(establishment.getEmail());
        if(foundEstablishmentByEmail.isPresent()) {
            throw new Exception("Email already exists");
        }

        Optional<Establishment> foundEstablishmentByDocument = this.establishmentRepository.findByDocument(establishment.getDocument());
        if(foundEstablishmentByDocument.isPresent()) {
            throw new Exception("Document already exists");
        }

        return this.establishmentRepository.save(establishment);
    }
}
