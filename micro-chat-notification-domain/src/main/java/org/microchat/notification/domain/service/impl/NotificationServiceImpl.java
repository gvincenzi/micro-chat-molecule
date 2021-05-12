package org.microchat.notification.domain.service.impl;

import org.microchat.notification.domain.entity.Notification;
import org.microchat.notification.domain.service.NotificationService;
import org.microchat.notification.domain.valence.MailValence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {
    @Autowired
    MailValence mailValence;

    @Override
    public void send(Notification notification) {
        mailValence.send(notification.getRecipient().getMail(), notification.getRecipient().getNickname(), notification.getSubject(), notification.getText());
    }
}
