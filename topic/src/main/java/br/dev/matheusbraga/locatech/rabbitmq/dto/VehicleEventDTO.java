package br.dev.matheusbraga.locatech.rabbitmq.dto;

import java.time.LocalDateTime;

public record VehicleEventDTO(
        String eventId,
        String vehicleType,
        String eventAction,
        String description,
        LocalDateTime eventDate
) { }
