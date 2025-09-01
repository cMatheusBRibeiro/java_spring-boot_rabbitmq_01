package br.dev.matheusbraga.locatech.rabbitmq.consumer;

import br.dev.matheusbraga.locatech.rabbitmq.configuration.RabbitMQConfiguration;
import br.dev.matheusbraga.locatech.rabbitmq.dto.VehicleEventDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class CarConsumer {

    private final Logger logger = LoggerFactory.getLogger(CarConsumer.class);

    @RabbitListener(queues = RabbitMQConfiguration.CAR_QUEUE)
    public void receiveCarEvent(VehicleEventDTO vehicleEventDTO) {
        logger.info("Receiving car event: {}", vehicleEventDTO);
    }

}
