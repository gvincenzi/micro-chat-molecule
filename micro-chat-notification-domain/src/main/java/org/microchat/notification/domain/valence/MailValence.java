package org.microchat.notification.domain.valence;

public interface MailValence {
    void send(String mail, String nickname, String subject, String text);
}
