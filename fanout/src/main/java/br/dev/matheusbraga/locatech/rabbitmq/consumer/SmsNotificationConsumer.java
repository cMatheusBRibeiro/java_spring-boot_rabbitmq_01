package br.dev.matheusbraga.locatech.rabbitmq.consumer;

import br.dev.matheusbraga.locatech.rabbitmq.configuration.RabbitMQConfiguration;
import br.dev.matheusbraga.locatech.rabbitmq.dto.NotificationDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class SmsNotificationConsumer {

    private final Logger logger = LoggerFactory.getLogger(SmsNotificationConsumer.class);

    @RabbitListener(queues = RabbitMQConfiguration.SMS_QUEUE)
    public void receiveSmsNotification(NotificationDTO notificationDTO) {
        logger.info("Receiving sms notification: {}", notificationDTO);
    }

}
