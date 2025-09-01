package br.dev.matheusbraga.locatech.rabbitmq.consumer;

import br.dev.matheusbraga.locatech.rabbitmq.configuration.RabbitMQConfiguration;
import br.dev.matheusbraga.locatech.rabbitmq.dto.NotificationDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PushNotificationConsumer {

    private final Logger logger = LoggerFactory.getLogger(PushNotificationConsumer.class);

    @RabbitListener(queues = RabbitMQConfiguration.PUSH_QUEUE)
    public void receivePushNotification(NotificationDTO notificationDTO) {
        logger.info("Receiving push notification: {}", notificationDTO);
    }

}
