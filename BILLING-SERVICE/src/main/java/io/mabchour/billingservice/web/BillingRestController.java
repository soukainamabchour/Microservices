package io.mabchour.billingservice.web;

import io.mabchour.billingservice.entities.Bill;
import io.mabchour.billingservice.entities.Customer;
import io.mabchour.billingservice.entities.Inventory;
import io.mabchour.billingservice.repository.BillRepository;
import io.mabchour.billingservice.repository.ProductItemRepository;
import io.mabchour.billingservice.service.CustomerRestClient;
import io.mabchour.billingservice.service.InventoryRestClient;
import org.checkerframework.checker.units.qual.g;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")

public class BillingRestController {
    private BillRepository billRepository;
    private ProductItemRepository productItemRepository;
    private CustomerRestClient customerRestClient;
    private InventoryRestClient inventoryRestClient;

    public BillingRestController(BillRepository billRepository,
             ProductItemRepository productItemRepository,
             CustomerRestClient customerRestClient,
             InventoryRestClient inventoryRestClient ){
        this.billRepository=billRepository;
        this.productItemRepository=productItemRepository;
        this.customerRestClient=customerRestClient;
        this.inventoryRestClient=inventoryRestClient;
    }
    @GetMapping(path = "/fullBill/{id}")
    public Bill getBill(@PathVariable(name = "id") Long id){
        Bill bill=billRepository.findById(id).get();
        Customer customer= customerRestClient.getCustomerById(bill.getCustomerID());
        bill.setCustomer(customer);
        bill.getProductItems().forEach(pi->{
            Inventory inventory=inventoryRestClient.getInventoryById(pi.getProductID());
            //pi.setInventory(inventory);
            pi.setInventoryName(inventory.getName());
        });
        return bill;
    }
}
