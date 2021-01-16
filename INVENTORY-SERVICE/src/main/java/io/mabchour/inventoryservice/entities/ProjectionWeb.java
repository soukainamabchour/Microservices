package io.mabchour.inventoryservice.entities;

import io.mabchour.inventoryservice.entities.Inventory;
import org.springframework.data.rest.core.config.Projection;

@Projection(name="web", types= Inventory.class)
public interface ProjectionWeb {
    String getName();
    double getPrice();
}
