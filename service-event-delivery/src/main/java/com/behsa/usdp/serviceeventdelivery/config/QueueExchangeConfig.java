package com.behsa.usdp.serviceeventdelivery.config;

import com.behsa.usdp.serviceeventdelivery.constrant.Constrant;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueExchangeConfig {
    @Bean
    Queue queue() {
        return new Queue(Constrant.DIRECT_QUEUE_NAME, true);
    }

    @Bean
    DirectExchange getDirectExchange() {
        return new DirectExchange(Constrant.DIRECT_EXCHANGE_NAME);
    }

    @Bean
    Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(Constrant.ROUTING_KEY);
    }

    @Bean
    MessageListenerAdapter getMessageListenerAdapter() {
        MessageListenerAdapter adapter = new MessageListenerAdapter();
        return adapter;
    }

}
