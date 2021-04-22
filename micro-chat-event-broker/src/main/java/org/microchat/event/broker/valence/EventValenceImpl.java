package org.microchat.event.broker.valence;

import org.microchat.domain.entity.Chat;
import org.microchat.domain.entity.ChatMessage;
import org.microchat.domain.entity.MicroChatEventType;
import org.microchat.domain.entity.Participant;
import org.microchat.domain.valence.EventValence;
import org.microchat.event.broker.binding.MicroChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class EventValenceImpl implements EventValence {
    @Autowired
    private MessageChannel messageChannel;

    @Autowired
    private MessageChannel subscriptionChannel;

    @Autowired
    private MessageChannel unsubscriptionChannel;

    @Override
    public void sendEvent(MicroChatEventType eventType, Participant participant, Chat chat) {
        MicroChatMessage microChatMessage = new MicroChatMessage();
        microChatMessage.setChat(chat);
        microChatMessage.setEventType(eventType);
        microChatMessage.setParticipant(participant);
        Message<MicroChatMessage> msg = MessageBuilder.withPayload(microChatMessage).build();

        switch (eventType){
            case JOIN: subscriptionChannel.send(msg); break;
            case LEAVE: unsubscriptionChannel.send(msg); break;
        }
    }

    @Override
    public void sendEvent(MicroChatEventType eventType, ChatMessage chatMessage) {
        MicroChatMessage microChatMessage = new MicroChatMessage();
        microChatMessage.setChat(chatMessage.getChat());
        microChatMessage.setEventType(eventType);
        microChatMessage.setParticipant(chatMessage.getAuthor());
        microChatMessage.setText(chatMessage.getText());
        Message<MicroChatMessage> msg = MessageBuilder.withPayload(microChatMessage).build();
        messageChannel.send(msg);
    }
}
