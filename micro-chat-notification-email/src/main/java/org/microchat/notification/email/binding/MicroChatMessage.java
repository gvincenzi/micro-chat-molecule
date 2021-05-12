package org.microchat.notification.email.binding;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MicroChatMessage {
    private MicroChatEventType eventType;
    private Participant participant;
    private Chat chat;
    private String text;
}
