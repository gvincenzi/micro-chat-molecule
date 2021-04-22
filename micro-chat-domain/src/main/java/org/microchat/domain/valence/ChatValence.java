package org.microchat.domain.valence;

import org.microchat.domain.entity.Chat;
import org.microchat.domain.entity.ChatMessage;
import org.microchat.domain.entity.Participant;

import java.util.Set;

public interface ChatValence {
    Set<Participant> joinChat(Participant participant, Chat chat);
    void leaveChat(Participant participant, Chat chat);
    void sendMessage(ChatMessage chatMessage);
}
