package br.dev.matheusbraga.locatech.rabbitmq.consumer;

import br.dev.matheusbraga.locatech.rabbitmq.configuration.RabbitMQConfiguration;
import br.dev.matheusbraga.locatech.rabbitmq.dto.VehicleEventDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ReservationConsumer {

    private final Logger logger = LoggerFactory.getLogger(ReservationConsumer.class);

    @RabbitListener(queues = RabbitMQConfiguration.RESERVATION_QUEUE)
    public void receiveReservationEvent(VehicleEventDTO vehicleEventDTO) {
        logger.info("Receiving reservation event: {}", vehicleEventDTO);
    }

}
