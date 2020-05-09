package nl.kolkos.chapter2.bootmessaging;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Log4j2
public class Sender {
    private final RabbitMessagingTemplate rabbitMessagingTemplate;

    @Bean
    public Queue queue() {
        return new Queue("TestQ", false);
    }

    public void send(String message) {
        log.info("Sending message: '{}'", message);
        rabbitMessagingTemplate.convertAndSend("TestQ", message);
    }

}
