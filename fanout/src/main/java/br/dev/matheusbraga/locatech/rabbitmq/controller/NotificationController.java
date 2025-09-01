package br.dev.matheusbraga.locatech.rabbitmq.controller;

import br.dev.matheusbraga.locatech.rabbitmq.dto.NotificationDTO;
import br.dev.matheusbraga.locatech.rabbitmq.service.NotificationPublisherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    private final NotificationPublisherService notificationPublisherService;

    public NotificationController(
            NotificationPublisherService notificationPublisherService
    ) {
        this.notificationPublisherService = notificationPublisherService;
    }

    @PostMapping("/send")
    public ResponseEntity<String> addReservationPayment (
            @RequestBody
            NotificationDTO notificationDTO
    ) {
        notificationPublisherService.sendNotification(notificationDTO);

        return ResponseEntity.ok().body("Notification sent successfully");
    }

}
