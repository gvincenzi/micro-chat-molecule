package org.microchat.core.domain.service;

import org.microchat.core.domain.entity.Chat;
import org.microchat.core.domain.entity.ChatMessage;
import org.microchat.core.domain.entity.Participant;

import java.util.Set;

public interface ChatService {
    Set<Participant> joinChat(Participant participant, Chat chat);
    void leaveChat(Participant participant, Chat chat);
    void sendMessage(ChatMessage chatMessage);
}
