package io.mabchour.customerservice;

import io.mabchour.customerservice.entities.Customer;
import io.mabchour.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerRepository customerRepository, RepositoryRestConfiguration repositoryRestConfiguration){
        repositoryRestConfiguration.exposeIdsFor(Customer.class);
        return args -> {
          customerRepository.save(new Customer(null, "Soukaina", "soukaina@gmail.com"));
          customerRepository.save(new Customer(null, "Souhayl", "souhayl@gmail.com"));
          customerRepository.save(new Customer(null, "Safaa", "safaa@gmail.com"));
          customerRepository.save(new Customer(null, "Mama", "mama@gmail.com"));
        };
    }
}
