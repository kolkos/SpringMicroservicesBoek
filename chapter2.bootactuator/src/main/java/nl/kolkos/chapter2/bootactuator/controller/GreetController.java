package nl.kolkos.chapter2.bootactuator.controller;

import nl.kolkos.chapter2.bootactuator.model.Greet;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {
    @CrossOrigin
    @RequestMapping("/")
    public Greet greet() {
        return new Greet("Hello World!");
    }

}
