package org.microchat.notification.domain.service;

import org.microchat.notification.domain.entity.Notification;

public interface NotificationService {
    void send(Notification notification);
}
