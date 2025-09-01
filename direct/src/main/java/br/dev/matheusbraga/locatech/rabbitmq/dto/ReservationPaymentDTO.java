package br.dev.matheusbraga.locatech.rabbitmq.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ReservationPaymentDTO(
        Long reservationId,
        String paymentMethod,
        BigDecimal paymentValue,
        LocalDateTime paymentDateTime
) { }
