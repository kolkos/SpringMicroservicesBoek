package nl.kolkos.chapter2.bootcustomernotification.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class Receiver {
    private final Mailer mailer;

    private final static String QUEUE_NAME = "CustomerQ";

    @Bean
    public Queue queue() {
        return new Queue(QUEUE_NAME, false);
    }

    @RabbitListener(queues = QUEUE_NAME)
    public void processMessage(String email) {
        log.info(email);
        mailer.sendMail(email);
    }
}
