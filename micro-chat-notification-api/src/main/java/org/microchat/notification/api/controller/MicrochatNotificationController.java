package org.microchat.notification.api.controller;

import lombok.extern.java.Log;
import org.microchat.notification.domain.entity.Notification;
import org.microchat.notification.domain.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@Log
@RestController
public class MicrochatNotificationController {
    @Autowired
    private NotificationService notificationService;

    @PostMapping("/notification")
    public ResponseEntity<Notification> postMessage(@RequestBody @NotNull Notification notification) {
        notificationService.send(notification);
        return new ResponseEntity<>(notification, HttpStatus.OK);
    }
}
