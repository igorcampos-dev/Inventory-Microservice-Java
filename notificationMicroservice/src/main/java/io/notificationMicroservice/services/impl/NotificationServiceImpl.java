package io.notificationMicroservice.services.impl;

import io.notificationMicroservice.entity.Notification;
import io.notificationMicroservice.entity.dto.NotificationDTO;
import io.notificationMicroservice.repositories.NotificationRepository;
import io.notificationMicroservice.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    public void save(NotificationDTO notificationDTO) {
        Optional.of(notificationRepository.save(new Notification(notificationDTO)))
                .orElseThrow(() -> new NullPointerException("Não foi possivel salvar no banco de dados"));
    }
}
