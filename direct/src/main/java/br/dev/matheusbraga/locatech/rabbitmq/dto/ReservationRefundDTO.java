package br.dev.matheusbraga.locatech.rabbitmq.dto;

import java.time.LocalDateTime;

public record ReservationRefundDTO(
        Long reservationId,
        LocalDateTime refundDateTime
) { }
