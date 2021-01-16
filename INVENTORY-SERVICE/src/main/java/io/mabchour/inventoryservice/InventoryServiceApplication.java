package io.mabchour.inventoryservice;

import io.mabchour.inventoryservice.entities.Inventory;
import io.mabchour.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(InventoryRepository inventoryRepository, RepositoryRestConfiguration repositoryRestConfiguration){
        repositoryRestConfiguration.exposeIdsFor(Inventory.class);
        return args -> {
            inventoryRepository.save(new Inventory(null, "Ordinateur", 8000.0, 1));
            inventoryRepository.save(new Inventory(null, "Smartphone", 4400.0, 2));
            inventoryRepository.save(new Inventory(null, "Des écouteurs", 600.0, 2));
        };
    }
}

