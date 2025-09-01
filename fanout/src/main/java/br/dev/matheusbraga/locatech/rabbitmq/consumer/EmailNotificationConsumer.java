package br.dev.matheusbraga.locatech.rabbitmq.consumer;

import br.dev.matheusbraga.locatech.rabbitmq.configuration.RabbitMQConfiguration;
import br.dev.matheusbraga.locatech.rabbitmq.dto.NotificationDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class EmailNotificationConsumer {

    private final Logger logger = LoggerFactory.getLogger(EmailNotificationConsumer.class);

    @RabbitListener(queues = RabbitMQConfiguration.EMAIL_QUEUE)
    public void receiveEmailNotification(NotificationDTO notificationDTO) {
        logger.info("Receiving email notification: {}", notificationDTO);
    }

}
