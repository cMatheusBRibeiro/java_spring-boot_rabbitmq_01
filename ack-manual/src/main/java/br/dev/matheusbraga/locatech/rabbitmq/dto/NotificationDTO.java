package br.dev.matheusbraga.locatech.rabbitmq.dto;

import java.time.LocalDateTime;

public record NotificationDTO(
        String notificationId,
        String title,
        String message,
        LocalDateTime sentAt
) {}
