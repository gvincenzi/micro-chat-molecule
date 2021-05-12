package org.microchat.core.domain.valence;

import org.microchat.core.domain.entity.Chat;
import org.microchat.core.domain.entity.ChatMessage;
import org.microchat.core.domain.entity.MicroChatEventType;
import org.microchat.core.domain.entity.Participant;

public interface EventValence {
    void sendEvent(MicroChatEventType eventType, Participant participant, Chat chat);
    void sendEvent(MicroChatEventType eventType, ChatMessage chatMessage);
}
