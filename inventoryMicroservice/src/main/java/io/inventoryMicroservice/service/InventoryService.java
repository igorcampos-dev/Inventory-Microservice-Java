package io.inventoryMicroservice.service;

public interface InventoryService {
    Integer getQuantidadeById(String id);

    void reserveProductByIdAndQuantity(String productId, int quantityId);

    void cancelReserveProductByIdAndQuantity(String productId, int quantityId);
}
