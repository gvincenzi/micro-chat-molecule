package org.microchat.domain.service.impl;

import org.microchat.domain.entity.Chat;
import org.microchat.domain.entity.ChatMessage;
import org.microchat.domain.entity.MicroChatEventType;
import org.microchat.domain.entity.Participant;
import org.microchat.domain.valence.ChatValence;
import org.microchat.domain.valence.EventValence;
import org.microchat.domain.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ChatServiceImpl implements ChatService {
    @Autowired
    ChatValence chatValence;
    @Autowired
    EventValence eventValence;

    @Override
    public Set<Participant> joinChat(Participant participant, Chat chat) {
        Set<Participant> participants = chatValence.joinChat(participant, chat);
        eventValence.sendEvent(MicroChatEventType.JOIN, participant, chat);
        return participants;
    }

    @Override
    public void leaveChat(Participant participant, Chat chat) {
        chatValence.leaveChat(participant, chat);
        eventValence.sendEvent(MicroChatEventType.LEAVE, participant, chat);
    }

    @Override
    public void sendMessage(ChatMessage chatMessage) {
        chatValence.sendMessage(chatMessage);
        eventValence.sendEvent(MicroChatEventType.MESSAGE, chatMessage);
    }
}
