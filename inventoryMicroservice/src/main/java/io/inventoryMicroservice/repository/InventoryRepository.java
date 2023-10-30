package io.inventoryMicroservice.repository;


import io.inventoryMicroservice.entity.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Inventory, String> {

    Optional<Inventory> findById(String id);
}
