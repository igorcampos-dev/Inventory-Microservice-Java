package io.orderMicroservice.services;

import io.orderMicroservice.entity.dto.OrderDTO;
import io.orderMicroservice.entity.dto.OrderGetDTO;
import io.orderMicroservice.entity.dto.OrderUpdateDTO;

public interface OrderService {
    void save(OrderDTO dto);

    OrderGetDTO getOrderById(String orderId);

    void updateStatus(OrderUpdateDTO dto);
}
