package io.inventoryMicroservice.controller;

import io.inventoryMicroservice.entity.model.dto.Response;
import io.inventoryMicroservice.service.InventoryService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    InventoryService inventoryService;



    @GetMapping("/{id}")
    public ResponseEntity<Response> getById(@PathVariable("id") String id){

        String quantity = inventoryService.getQuantidadeById(id).toString();

        return ResponseEntity.status(HttpStatus.OK).body(new Response(quantity));

    }


    @Transactional
    @PutMapping("/reserve/productId/{productId}/quantityId/{quantityId}")
    public ResponseEntity<Response> save( @PathVariable("productId") String productId, @PathVariable("quantityId") int quantityId ){

        inventoryService.reserveProductByIdAndQuantity(productId, quantityId);
        return ResponseEntity.status(HttpStatus.OK).body(new Response("Salvo!"));
    }

    @Transactional
    @PutMapping("/release/productId/{productId}/quantityId/{quantityId}")
    public ResponseEntity<Response> updateProducts(@PathVariable("productId") String productId,  @PathVariable("quantityId") int quantityId){
        inventoryService.cancelReserveProductByIdAndQuantity(productId, quantityId);

        return ResponseEntity.status(HttpStatus.OK).body(new Response("Campos atualizados"));
    }

    @GetMapping
    public ResponseEntity<String> status(){
        return ResponseEntity.ok().body("ok");
    }
}
