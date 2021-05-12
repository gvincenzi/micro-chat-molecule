package org.microchat.core.event.broker.binding;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.microchat.core.domain.entity.Chat;
import org.microchat.core.domain.entity.MicroChatEventType;
import org.microchat.core.domain.entity.Participant;

@Data
@NoArgsConstructor
public class MicroChatMessage {
    private MicroChatEventType eventType;
    private Participant participant;
    private Chat chat;
    private String text;
}
