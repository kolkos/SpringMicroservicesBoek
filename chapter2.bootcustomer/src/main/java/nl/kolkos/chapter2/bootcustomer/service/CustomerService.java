package nl.kolkos.chapter2.bootcustomer.service;

import lombok.RequiredArgsConstructor;
import nl.kolkos.chapter2.bootcustomer.entity.Customer;
import nl.kolkos.chapter2.bootcustomer.repositoy.CustomerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public Customer register(Customer customer) {
        Optional<Customer> existingCustomer = customerRepository.findByName(customer.getName());
        if(existingCustomer.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Customer already exists");
        }

        return customerRepository.save(customer);
    }
}
