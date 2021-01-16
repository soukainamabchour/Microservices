package io.mabchour.inventoryservice.entities;

import io.mabchour.inventoryservice.entities.Inventory;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "mobile", types= Inventory.class)
public interface ProjectionMobile {
    String getName();
}

