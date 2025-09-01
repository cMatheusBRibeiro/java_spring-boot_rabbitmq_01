package br.dev.matheusbraga.locatech.rabbitmq.consumer;

import br.dev.matheusbraga.locatech.rabbitmq.configuration.RabbitMQConfiguration;
import br.dev.matheusbraga.locatech.rabbitmq.dto.VehicleEventDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MaintenanceConsumer {

    private final Logger logger = LoggerFactory.getLogger(MaintenanceConsumer.class);

    @RabbitListener(queues = RabbitMQConfiguration.MAINTENANCE_QUEUE)
    public void receiveMaintenanceEvent(VehicleEventDTO vehicleEventDTO) {
        logger.info("Receiving maintenance event: {}", vehicleEventDTO);
    }

}
