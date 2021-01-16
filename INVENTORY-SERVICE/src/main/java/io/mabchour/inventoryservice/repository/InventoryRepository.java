package io.mabchour.inventoryservice.repository;

import io.mabchour.inventoryservice.entities.Inventory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin("*")

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    @RestResource(path="/byName")
    Page<Inventory> findByNameContains(@Param("kw") String name, Pageable pageable);

}
