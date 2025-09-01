package br.dev.matheusbraga.locatech.rabbitmq.controller;

import br.dev.matheusbraga.locatech.rabbitmq.dto.ReservationPaymentDTO;
import br.dev.matheusbraga.locatech.rabbitmq.dto.ReservationRefundDTO;
import br.dev.matheusbraga.locatech.rabbitmq.service.ReservationPublisherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    private final ReservationPublisherService reservationPublisherService;

    public ReservationController(
            ReservationPublisherService reservationPublisherService
    ) {
        this.reservationPublisherService = reservationPublisherService;
    }

    @PostMapping("/payment")
    public ResponseEntity<String> addReservationPayment (
            @RequestBody
            ReservationPaymentDTO reservationPaymentDTO
    ) {
        reservationPublisherService.sendReservationPayment(reservationPaymentDTO);

        return ResponseEntity.ok().body("Reservation Payment Successfully Added");
    }

    @PostMapping("/refund")
    public ResponseEntity<String> addReservationRefund (
            @RequestBody
            ReservationRefundDTO reservationRefundDTO
    ) {
        reservationPublisherService.sendReservationRefund(reservationRefundDTO);

        return ResponseEntity.ok().body("Reservation Refund Successfully Added");
    }

}
