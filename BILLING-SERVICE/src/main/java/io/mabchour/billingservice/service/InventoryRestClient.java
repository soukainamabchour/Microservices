package io.mabchour.billingservice.service;

import io.mabchour.billingservice.entities.Inventory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@FeignClient(name = "INVENTORY-SERVICE")
public interface InventoryRestClient {
    @GetMapping(path = "/inventories")
    PagedModel<Inventory> pagedInventories();
    @GetMapping(path = "/inventories/{id}")
    Inventory getInventoryById(@PathVariable Long id);
}
