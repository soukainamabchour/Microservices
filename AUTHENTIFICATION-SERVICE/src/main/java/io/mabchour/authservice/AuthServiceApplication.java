package io.mabchour.authservice;

import io.mabchour.authservice.Entities.AppRole;
import io.mabchour.authservice.Entities.AppUser;
import io.mabchour.authservice.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;


import java.util.ArrayList;

@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true)
public class AuthServiceApplication implements CommandLineRunner {

    @Autowired
    private  AccountService accountService;

    public static void main(String[] args) {
        SpringApplication.run(AuthServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        accountService.addNewRole(new AppRole(null,"USER"));
        accountService.addNewRole(new AppRole(null,"ADMIN"));
        accountService.addNewRole(new AppRole(null,"CUSTOMER_MANAGER"));
        accountService.addNewRole(new AppRole(null,"PRODUCT_MANAGER"));
        accountService.addNewRole(new AppRole(null,"BILLS_MANAGER"));

        accountService.addNewUser(new AppUser(null,"user1","1234",new ArrayList<>()));
        accountService.addNewUser(new AppUser(null,"admin","1234",new ArrayList<>()));
        accountService.addNewUser(new AppUser(null,"user2","1234",new ArrayList<>()));
        accountService.addNewUser(new AppUser(null,"user3","1234",new ArrayList<>()));
        accountService.addNewUser(new AppUser(null,"user4","1234",new ArrayList<>()));

        accountService.addRoleToUser("user1","USER");
        accountService.addRoleToUser("admin","USER");
        accountService.addRoleToUser("admin","ADMIN");
        accountService.addRoleToUser("user2","USER");
        accountService.addRoleToUser("user2","CUSTOMER_MANAGER");
        accountService.addRoleToUser("user3","USER");
        accountService.addRoleToUser("user3","PRODUCT_MANAGER");
        accountService.addRoleToUser("user4","USER");
        accountService.addRoleToUser("user4","BILLS_MANAGER");
    }
}
