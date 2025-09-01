package br.dev.matheusbraga.locatech.rabbitmq.service;

import br.dev.matheusbraga.locatech.rabbitmq.configuration.RabbitMQConfiguration;
import br.dev.matheusbraga.locatech.rabbitmq.dto.ReservationPaymentDTO;
import br.dev.matheusbraga.locatech.rabbitmq.dto.ReservationRefundDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class ReservationPublisherService {

    private final RabbitTemplate rabbitTemplate;

    public ReservationPublisherService (RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendReservationPayment (ReservationPaymentDTO reservationPaymentDTO) {
        rabbitTemplate.convertAndSend(
                RabbitMQConfiguration.EXCHANGE_NAME,
                RabbitMQConfiguration.ROUTING_KEY_PAYMENT,
                reservationPaymentDTO
        );
    }

    public void sendReservationRefund (ReservationRefundDTO reservationRefundDTO) {
        rabbitTemplate.convertAndSend(
                RabbitMQConfiguration.EXCHANGE_NAME,
                RabbitMQConfiguration.ROUTING_KEY_REFUND,
                reservationRefundDTO
        );
    }

}
