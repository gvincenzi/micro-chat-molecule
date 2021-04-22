package org.microchat.domain.service;

import org.microchat.domain.entity.Chat;
import org.microchat.domain.entity.ChatMessage;
import org.microchat.domain.entity.Participant;

import java.util.Set;

public interface ChatService {
    Set<Participant> joinChat(Participant participant, Chat chat);
    void leaveChat(Participant participant, Chat chat);
    void sendMessage(ChatMessage chatMessage);
}
