package com.learning.deliveryman.modules.establishment.controller;

import com.learning.deliveryman.modules.establishment.dto.EstablishmentDto;
import com.learning.deliveryman.modules.establishment.entity.Establishment;
import com.learning.deliveryman.modules.establishment.service.EstablishmentService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/establishment")
public class EstablishmentController {

    private final EstablishmentService establishmentService;

    public EstablishmentController(EstablishmentService establishmentService) {
        this.establishmentService = establishmentService;
    }

    @PostMapping
    public ResponseEntity<Object> createEstablishment(@RequestBody @Valid EstablishmentDto establishmentDto) {
        var establishment = new Establishment();
        BeanUtils.copyProperties(establishmentDto, establishment);
        var response = this.establishmentService.save(establishment);
        return  ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
