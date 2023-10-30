package io.notificationMicroservice.controllers;

import io.notificationMicroservice.entity.dto.NotificationDTO;
import io.notificationMicroservice.services.NotificationService;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping("/notification")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;


    @PostMapping("/send")
    public ResponseEntity<String> saveNotification(@RequestBody @Valid NotificationDTO dto) {
        notificationService.save(dto);
        return ResponseEntity.ok("Salvo!");
    }




    @GetMapping
    public ResponseEntity<String> status(){
        return ResponseEntity.ok().body("ok");
    }

}
