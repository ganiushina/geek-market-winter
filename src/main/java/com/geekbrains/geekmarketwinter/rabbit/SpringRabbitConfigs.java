package com.geekbrains.geekmarketwinter.rabbit;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringRabbitConfigs {
    private static final String EXCHANGE_NAME = "fanout";
    private static final String QUEUE_NAME = "shop";
    @Bean
    public Queue createQueue() {
           return new Queue(QUEUE_NAME, true);
    }
    @Bean
    public Exchange fanoutExchange() {
        return new FanoutExchange(EXCHANGE_NAME, true, false);
    }
    @Bean
    public Binding queueBinding() {
        return new Binding(QUEUE_NAME, Binding.DestinationType.QUEUE, EXCHANGE_NAME, "", null);
    }

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory("localhost");
        return connectionFactory;
    }

}
