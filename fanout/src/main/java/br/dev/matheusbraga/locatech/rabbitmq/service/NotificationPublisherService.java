package br.dev.matheusbraga.locatech.rabbitmq.service;

import br.dev.matheusbraga.locatech.rabbitmq.configuration.RabbitMQConfiguration;
import br.dev.matheusbraga.locatech.rabbitmq.dto.NotificationDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificationPublisherService {

    private final RabbitTemplate rabbitTemplate;

    public NotificationPublisherService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendNotification (NotificationDTO notificationDTO) {
        rabbitTemplate.convertAndSend(
                RabbitMQConfiguration.EXCHANGE_NAME,
                "",
                notificationDTO
        );
    }

}
