package nl.kolkos.chapter2.bootcustomer.controller;

import lombok.RequiredArgsConstructor;
import nl.kolkos.chapter2.bootcustomer.entity.Customer;
import nl.kolkos.chapter2.bootcustomer.service.CustomerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("/register")
    public Customer register(@RequestBody Customer customer) {
        return customerService.register(customer);
    }

}
