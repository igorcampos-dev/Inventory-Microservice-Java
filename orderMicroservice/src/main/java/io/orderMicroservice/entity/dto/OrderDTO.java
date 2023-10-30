package io.orderMicroservice.entity.dto;

import io.orderMicroservice.entity.model.Products;
import lombok.Data;

import java.util.List;

public record OrderDTO(Customer customer, List<Products> products, Payment payment) {


    @Data
    public static class Customer{
        private String customer_id;
        private String first_name;
        private String last_name;
        private String email;
        private String address;
    }

    @Data
    public static class Payment{
        private String payment_method;
        private String card_number;
        private String expiration_date;
        private String cvv;
    }


}
