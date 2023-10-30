package io.inventoryMicroservice.service.impl;

import io.inventoryMicroservice.entity.model.Inventory;
import io.inventoryMicroservice.repository.InventoryRepository;
import io.inventoryMicroservice.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryImpl implements InventoryService {

    @Autowired
    InventoryRepository inventoryRepository;

    @Override
    public Integer getQuantidadeById(String id) {
        return inventoryRepository.findById(id).map(Inventory::getQuantity).orElse(null);
    }

    @Override
    public void reserveProductByIdAndQuantity(String productId, int quantityId) {


        inventoryRepository.findById(productId)
                .map(
                  s -> {
                      if (s.getQuantity() < quantityId){throw new RuntimeException("não temos produtos suficientes!");}

                          s.setQuantity(s.getQuantity() - quantityId);
                          s.setReserved_quantity(quantityId);
                          return inventoryRepository.save(s);

                  }
                ).orElseThrow(() -> new NullPointerException("usuário não existe!"));
    }

    @Override
    public void cancelReserveProductByIdAndQuantity(String productId, int quantityId) {

        inventoryRepository.findById(productId)
                .map(
                 s -> {
                     if (quantityId > s.getReserved_quantity()) {throw new RuntimeException("você enviou mais produtos do que produtos reservados existentes no banco!");}
                     s.setReserved_quantity(s.getReserved_quantity() - quantityId);
                     s.setQuantity(s.getQuantity() + quantityId);
                     return inventoryRepository.save(s);
                 }
                ).orElseThrow(() -> new NullPointerException("Não existe produto cadastrado com esas informacoes!"));
    }


}
