package chapter2.bootrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class GreetingController {
    private static final Logger logger = LoggerFactory.getLogger(GreetingController.class);

    Environment env;

    @Autowired
    GreetingController(Environment env){
        this.env = env;
    }

    @CrossOrigin
    @RequestMapping("/")
    Greet greet(){
        logger.info("bootrest.customproperty "+ env.getProperty("bootrest.customproperty"));
        return new Greet("Hello World!");
    }
}
