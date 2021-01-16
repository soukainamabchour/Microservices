package io.mabchour.billingservice;

import io.mabchour.billingservice.entities.Bill;
import io.mabchour.billingservice.entities.Customer;
import io.mabchour.billingservice.entities.Inventory;
import io.mabchour.billingservice.entities.ProductItem;
import io.mabchour.billingservice.repository.BillRepository;
import io.mabchour.billingservice.repository.ProductItemRepository;
import io.mabchour.billingservice.service.CustomerRestClient;
import io.mabchour.billingservice.service.InventoryRestClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.PagedModel;

import java.util.Collection;
import java.util.Date;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(BillRepository billRepository,
                            ProductItemRepository productItemRepository,
                            CustomerRestClient customerRestClient,
                            InventoryRestClient inventoryRestClient){
        return args -> {

            Customer customer=customerRestClient.getCustomerById(1L);
           Bill bill= billRepository.save(new Bill(null, new Date(), null, customer.getId(), customer, null));
            PagedModel<Inventory> pagedInventories=inventoryRestClient.pagedInventories();
            pagedInventories.forEach(pi->{
                ProductItem productItem=new ProductItem();
                productItem.setPrice(pi.getPrice()*0.2);
                productItem.setProductID(pi.getId());
                productItem.setQuantity(1+new Random().nextInt(100));
                productItem.setBill(bill);
                productItemRepository.save(productItem);

            });
            System.out.println("************************************");
            System.out.println(customer.toString());
            System.out.println("************************************");
        };
    }
}
