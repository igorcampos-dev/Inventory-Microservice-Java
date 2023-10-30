package io.orderMicroservice.entity.dto;
import lombok.Builder;
import lombok.Data;

public record OrderGetDTO(Customer customer, Payment payment, String status) {


    @Data
    @Builder
    public static class Customer{
        private String first_name;
        private String last_name;
        private String email;
        private String address;
    }

    @Data
    @Builder
    public static class Payment{
        private String payment_method;
        private String card_number;
        private String expiration_date;
    }



}
