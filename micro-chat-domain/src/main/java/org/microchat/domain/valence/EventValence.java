package org.microchat.domain.valence;

import org.microchat.domain.entity.Chat;
import org.microchat.domain.entity.ChatMessage;
import org.microchat.domain.entity.MicroChatEventType;
import org.microchat.domain.entity.Participant;

public interface EventValence {
    void sendEvent(MicroChatEventType eventType, Participant participant, Chat chat);
    void sendEvent(MicroChatEventType eventType, ChatMessage chatMessage);
}
