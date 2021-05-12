package org.microchat.notification.email.valence;

import org.microchat.notification.domain.valence.MailValence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailValenceImpl implements MailValence {
    @Autowired
    public JavaMailSender javaMailSender;

    @Override
    public void send(String mail, String nickname, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(mail);
        message.setSubject(subject);
        message.setText(text);
        javaMailSender.send(message);
    }
}
