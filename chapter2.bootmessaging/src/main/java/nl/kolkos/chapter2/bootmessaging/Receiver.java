package nl.kolkos.chapter2.bootmessaging;

import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class Receiver {

    @RabbitListener(queues = "TestQ")
    public void processMessage(String content) {
        log.info(content);
    }

}
