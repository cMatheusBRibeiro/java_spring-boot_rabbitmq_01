package br.dev.matheusbraga.locatech.rabbitmq.consumer;

import br.dev.matheusbraga.locatech.rabbitmq.configuration.RabbitMQConfiguration;
import br.dev.matheusbraga.locatech.rabbitmq.dto.ReservationPaymentDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ReservationPaymentConsumer {

    private final Logger logger = LoggerFactory.getLogger(ReservationPaymentConsumer.class);

    @RabbitListener(queues = RabbitMQConfiguration.PAYMENT_QUEUE)
    public void receivePayment(ReservationPaymentDTO reservationPaymentDTO) {
        logger.info("Receiving payment for new reservation: {}", reservationPaymentDTO);
    }

}
