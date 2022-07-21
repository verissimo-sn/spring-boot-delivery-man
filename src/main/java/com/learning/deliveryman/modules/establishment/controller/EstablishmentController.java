package com.learning.deliveryman.modules.establishment.controller;

import com.learning.deliveryman.modules.establishment.dtos.CreateEstablishmentDto;
import com.learning.deliveryman.modules.establishment.dtos.ResponseEstablishmentDto;
import com.learning.deliveryman.modules.establishment.entity.Establishment;
import com.learning.deliveryman.modules.establishment.service.EstablishmentService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/establishment")
public class EstablishmentController {

    private final EstablishmentService establishmentService;

    public EstablishmentController(EstablishmentService establishmentService) {
        this.establishmentService = establishmentService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getEstablishment(@PathVariable(value = "id") String id) {
        try {
            var response = new ResponseEstablishmentDto();
            BeanUtils.copyProperties(this.establishmentService.getOneById(id), response);
            return  ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception error) {
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<Object> createEstablishment(@RequestBody @Valid CreateEstablishmentDto createEstablishmentDto) {
        try {
            var establishment = new Establishment();
            BeanUtils.copyProperties(createEstablishmentDto, establishment);
            var response = new ResponseEstablishmentDto();
            BeanUtils.copyProperties(this.establishmentService.save(establishment), response);
            return  ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception error) {
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }
    @PutMapping("/{id}/change-status")
    public ResponseEntity<Object> changeEstablishmentStatus(@PathVariable(value = "id") String id) {
        try {
            var response = this.establishmentService.changeStatus((id));
            return  ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception error) {
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }


}
