package br.dev.matheusbraga.locatech.rabbitmq.controller;

import br.dev.matheusbraga.locatech.rabbitmq.dto.VehicleEventDTO;
import br.dev.matheusbraga.locatech.rabbitmq.service.VehicleEventPublisherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/events")
public class VehicleEventController {

    private final VehicleEventPublisherService vehicleEventPublisherService;

    public VehicleEventController(
            VehicleEventPublisherService vehicleEventPublisherService
    ) {
        this.vehicleEventPublisherService = vehicleEventPublisherService;
    }

    @PostMapping("/send")
    public ResponseEntity<String> addReservationPayment (
            @RequestBody
            VehicleEventDTO vehicleEventDTO
    ) {
        String routingKey = "vehicle." + vehicleEventDTO.vehicleType().toLowerCase() + "." + vehicleEventDTO.eventAction().toLowerCase();

        System.out.println(routingKey);

        vehicleEventPublisherService.sendEvent(vehicleEventDTO, routingKey);

        return ResponseEntity.ok().body("Event sent successfully");
    }

}
