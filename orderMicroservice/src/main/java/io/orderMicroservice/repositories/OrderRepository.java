package io.orderMicroservice.repositories;

import io.orderMicroservice.entity.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {

}
