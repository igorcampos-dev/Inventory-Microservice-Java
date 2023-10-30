package io.orderMicroservice.controllers;

import io.orderMicroservice.entity.dto.OrderDTO;
import io.orderMicroservice.entity.dto.OrderGetDTO;
import io.orderMicroservice.entity.dto.OrderUpdateDTO;
import io.orderMicroservice.entity.dto.Response;
import io.orderMicroservice.services.OrderService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrdersController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/save/order")
    public ResponseEntity<Response> saveOrders(@RequestBody @Valid OrderDTO dto){
        orderService.save(dto);
        return ResponseEntity.status(HttpStatus.OK).body(new Response("salvo!"));
    }


    @GetMapping("/get/order/{orderId}")
    public ResponseEntity<OrderGetDTO> getOrders(@PathVariable("orderId") String orderId){
       OrderGetDTO orderGetDTO = orderService.getOrderById(orderId);
        return ResponseEntity.ok().body(orderGetDTO);
    }

    @Transactional
    @PutMapping("/put/order")
    public ResponseEntity<Response> updateStatus(@RequestBody @Valid OrderUpdateDTO dto){
        orderService.updateStatus(dto);
        return ResponseEntity.status(HttpStatus.OK).body(new Response("Status modificado!"));
    }
}
