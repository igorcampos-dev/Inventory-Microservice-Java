package io.notificationMicroservice.entity.dto;

import lombok.Data;

public record NotificationDTO(notifications notification) {


    @Data
    public static class notifications{
        private String order_id;
        private String notification_type;
        private String recipient;
        private String content;
    }

}
