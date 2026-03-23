package com.example.study_rabbitmq._core.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.JacksonJsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    public static final String QUEUE_NAME = "post-queue";
    public static final String EXCHANGE_NAME = "post-exchange";
    public static final String ROUTING_KEY = "post.created";

    // 큐 등록 (Simple Queue 실습용)
    @Bean
    public Queue queue() {
        return new Queue(QUEUE_NAME, false);
    }

    // 익스체인지 등록 (Direct 방식)
    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(EXCHANGE_NAME);
    }

    // 바인딩 (큐와 익스체인지를 라우팅 키로 연결)
    @Bean
    public Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
    }

    // 메시지 객체를 JSON으로 변환하기 위한 컨버터 설정
    @Bean
    public MessageConverter jsonMessageConverter() {
        return new JacksonJsonMessageConverter();
    }

    // RabbitTemplate 설정 (컨버터 주입)
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }
}
