package br.dev.matheusbraga.locatech.rabbitmq.service;

import br.dev.matheusbraga.locatech.rabbitmq.configuration.RabbitMQConfiguration;
import br.dev.matheusbraga.locatech.rabbitmq.dto.VehicleEventDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class VehicleEventPublisherService {

    private final RabbitTemplate rabbitTemplate;

    public VehicleEventPublisherService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendEvent (VehicleEventDTO vehicleEventDTO, String routingKey) {
        rabbitTemplate.convertAndSend(
                RabbitMQConfiguration.EXCHANGE_NAME,
                routingKey,
                vehicleEventDTO
        );
    }

}
