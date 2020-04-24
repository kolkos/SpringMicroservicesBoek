package nl.kolkos.chapter2.legacyrest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public Greet sayHello() {
        return new Greet("Hello World!");
    }
}
