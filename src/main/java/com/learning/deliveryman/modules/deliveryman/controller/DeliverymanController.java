package com.learning.deliveryman.modules.deliveryman.controller;

import com.learning.deliveryman.modules.deliveryman.dtos.CreateDeliverymanDto;
import com.learning.deliveryman.modules.deliveryman.dtos.ResponseDeliverymanDto;
import com.learning.deliveryman.modules.deliveryman.entity.Deliveryman;
import com.learning.deliveryman.modules.deliveryman.service.DeliverymanService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/deliveryman")
public class DeliverymanController {
    private final DeliverymanService deliverymanService;

    DeliverymanController(DeliverymanService deliverymanService) {
        this.deliverymanService = deliverymanService;
    }

    @PostMapping
    public ResponseEntity<Object> createDeliveryman(@RequestBody CreateDeliverymanDto deliverymanDto) {
        try {
            Deliveryman deliveryman = new Deliveryman();
            BeanUtils.copyProperties(deliverymanDto, deliveryman);
            ResponseDeliverymanDto response = new ResponseDeliverymanDto();
            BeanUtils.copyProperties(this.deliverymanService.save(deliveryman), response);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }

    @PutMapping("/{id}/change-status")
    public ResponseEntity<Object> changeDeliverymanStatus(@PathVariable(value = "id") String id) {
        try {
            var response = this.deliverymanService.changeStatus((id));
            return  ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception error) {
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }
}
