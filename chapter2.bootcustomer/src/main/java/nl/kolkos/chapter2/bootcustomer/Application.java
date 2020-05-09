package nl.kolkos.chapter2.bootcustomer;

import nl.kolkos.chapter2.bootcustomer.entity.Customer;
import nl.kolkos.chapter2.bootcustomer.repositoy.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner init(CustomerRepository customerRepository) {
		return (evt) -> {
			customerRepository.save(new Customer("Adam", "adam@boot.com"));
			customerRepository.save(new Customer("John", "john@boot.com"));
			customerRepository.save(new Customer("Smith", "smith@boot.com"));
			customerRepository.save(new Customer("Edgar", "edgar@boot.com"));
			customerRepository.save(new Customer("Martin", "martin@boot.com"));
			customerRepository.save(new Customer("Tom", "tom@boot.com"));
			customerRepository.save(new Customer("Sean", "sean@boot.com"));
		};
	}

}
