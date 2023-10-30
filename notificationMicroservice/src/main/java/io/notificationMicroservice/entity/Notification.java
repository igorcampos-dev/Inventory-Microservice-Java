package io.notificationMicroservice.entity;

import io.notificationMicroservice.entity.dto.NotificationDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "notificacao")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(of = "id")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String order_id;
    private String notification_type;
    private String recipient;
    private String content;

    public Notification(NotificationDTO dto){
        this.order_id = dto.notification().getOrder_id();
        this.notification_type = dto.notification().getNotification_type();
        this.recipient = dto.notification().getRecipient();
        this.content = dto.notification().getContent();
    }

}
