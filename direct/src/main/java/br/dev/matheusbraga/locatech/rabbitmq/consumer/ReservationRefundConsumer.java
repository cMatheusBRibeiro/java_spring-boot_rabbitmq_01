package br.dev.matheusbraga.locatech.rabbitmq.consumer;

import br.dev.matheusbraga.locatech.rabbitmq.configuration.RabbitMQConfiguration;
import br.dev.matheusbraga.locatech.rabbitmq.dto.ReservationPaymentDTO;
import br.dev.matheusbraga.locatech.rabbitmq.dto.ReservationRefundDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ReservationRefundConsumer {

    private final Logger logger = LoggerFactory.getLogger(ReservationRefundConsumer.class);

    @RabbitListener(queues = RabbitMQConfiguration.REFUND_QUEUE)
    public void receiveRefund(ReservationRefundDTO reservationRefundDTO) {
        logger.info("Receiving refund for reservation: {}", reservationRefundDTO);
    }

}
