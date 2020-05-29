package nl.kolkos.chapter2.bootcustomer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
@RequiredArgsConstructor
@Log4j2
public class Sender {
    private final RabbitMessagingTemplate rabbitMessagingTemplate;

    private final static String QUEUE_NAME = "CustomerQ";

    @Bean
    public Queue queue() {
        return new Queue(QUEUE_NAME, false);
    }

    public void send(String message) {
        log.info("Sending message '{}' to queue '{}'", message, QUEUE_NAME);
        rabbitMessagingTemplate.convertAndSend(QUEUE_NAME, message);
    }
}
