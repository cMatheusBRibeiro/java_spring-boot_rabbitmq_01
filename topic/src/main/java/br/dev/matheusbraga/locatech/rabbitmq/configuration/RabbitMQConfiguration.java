package br.dev.matheusbraga.locatech.rabbitmq.configuration;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {

    public static final String EXCHANGE_NAME = "events_exchange";

    public static final String CAR_QUEUE = "car_queue";
    public static final String MAINTENANCE_QUEUE = "maintenance_queue";
    public static final String RESERVATION_QUEUE = "reservation_queue";

    public static final String ROUTING_KEY_CAR_ALL = "vehicle.car.*";
    public static final String ROUTING_KEY_MAINTENANCE = "*.*.maintenance";
    public static final String ROUTING_KEY_RESERVATION = "vehicle.*.reservation";

    @Bean
    public TopicExchange directExchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    public Queue carQueue() {
        return new Queue(CAR_QUEUE, true);
    }

    @Bean
    public Queue maintenanceQueue() {
        return new Queue(MAINTENANCE_QUEUE, true);
    }

    @Bean
    public Queue reservationQueue() {
        return new Queue(RESERVATION_QUEUE, true);
    }

    @Bean
    public Binding carBinding(Queue carQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(carQueue).to(topicExchange).with(ROUTING_KEY_CAR_ALL);
    }

    @Bean
    public Binding maintenanceBinding(Queue maintenanceQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(maintenanceQueue).to(topicExchange).with(ROUTING_KEY_MAINTENANCE);
    }

    @Bean
    public Binding reservationBinding(Queue reservationQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(reservationQueue).to(topicExchange).with(ROUTING_KEY_RESERVATION);
    }

    @Bean
    public Jackson2JsonMessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);

        rabbitTemplate.setMessageConverter(jsonMessageConverter());

        return rabbitTemplate;
    }

}
