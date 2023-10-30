package io.notificationMicroservice.services;

import io.notificationMicroservice.entity.dto.NotificationDTO;

public interface NotificationService {
    void save(NotificationDTO notificationDTO);
}
