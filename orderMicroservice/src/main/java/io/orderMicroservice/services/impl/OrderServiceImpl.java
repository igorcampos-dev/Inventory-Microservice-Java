package io.orderMicroservice.services.impl;

import io.orderMicroservice.entity.dto.OrderDTO;
import io.orderMicroservice.entity.dto.OrderGetDTO;
import io.orderMicroservice.entity.dto.OrderUpdateDTO;
import io.orderMicroservice.entity.enums.Status;
import io.orderMicroservice.entity.model.Order;
import io.orderMicroservice.repositories.OrderRepository;
import io.orderMicroservice.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;


    @Override
    public void save(OrderDTO dto) {
        Order order = new Order(dto);
        order.setStatus(Status.PENDENTE.getValue());

        Optional.of(orderRepository.save(order)).orElseThrow();
    }

    @Override
    public OrderGetDTO getOrderById(String orderId) {
        Optional<Order> order = orderRepository.findById(orderId);
        return mapOrderToDTO(order);
    }

    @Override
    public void updateStatus(OrderUpdateDTO dto) {

       Status.fromString(dto.delivery_status())
                .orElseThrow(() -> new NullPointerException("Status inválido: " + dto.delivery_status()));

        orderRepository.findById(dto.order_id())
                .ifPresentOrElse(
                        order -> {
                            order.setStatus(dto.delivery_status());
                            orderRepository.save(order);
                            },
                        () -> {throw new NullPointerException("O pedido é nulo!");}
                );
    }



    public OrderGetDTO mapOrderToDTO(Optional<Order> order) {

        OrderGetDTO.Customer customer = OrderGetDTO.Customer.builder()
                .address(order.get().getAddress())
                .email(order.get().getEmail())
                .first_name(order.get().getFirst_name())
                .last_name(order.get().getLast_name())
                .build();

        OrderGetDTO.Payment payment = OrderGetDTO.Payment.builder()
                .payment_method(order.get().getPayment_method())
                .card_number(order.get().getCard_number())
                .expiration_date(order.get().getExpiration_date())
                .build();

        return new OrderGetDTO(customer, payment, order.get().getStatus());
    }

}
