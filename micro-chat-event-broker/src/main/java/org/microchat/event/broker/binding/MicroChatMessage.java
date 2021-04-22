package org.microchat.event.broker.binding;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.microchat.domain.entity.Chat;
import org.microchat.domain.entity.ChatMessage;
import org.microchat.domain.entity.MicroChatEventType;
import org.microchat.domain.entity.Participant;

@Data
@NoArgsConstructor
public class MicroChatMessage {
    private MicroChatEventType eventType;
    private Participant participant;
    private Chat chat;
    private String text;
}
