package br.dev.matheusbraga.locatech.rabbitmq.consumer;

import br.dev.matheusbraga.locatech.rabbitmq.configuration.RabbitMQConfiguration;
import br.dev.matheusbraga.locatech.rabbitmq.dto.NotificationDTO;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class SmsNotificationConsumer {

    private final Logger logger = LoggerFactory.getLogger(SmsNotificationConsumer.class);

    @RabbitListener(queues = RabbitMQConfiguration.SMS_QUEUE, containerFactory = "manualAckListenerContainerFactory")
    public void receiveSmsNotification(NotificationDTO notificationDTO, Message message, Channel channel) {
        try {
            logger.info("Receiving sms notification: {}", notificationDTO);
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception e) {
            logger.error("Error while receiving sms notification: " + e.getMessage(), e);
        }
    }

}
