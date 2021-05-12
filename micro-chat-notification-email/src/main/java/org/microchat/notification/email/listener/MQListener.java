package org.microchat.notification.email.listener;

import org.microchat.notification.domain.valence.MailValence;
import org.microchat.notification.email.binding.MQBinding;
import org.microchat.notification.email.binding.MicroChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(MQBinding.class)
public class MQListener {
    @Autowired
    MailValence mailValence;

    @StreamListener(target = MQBinding.SUBSCRIPTION)
    public void processSubscription(MicroChatMessage msg) {
        mailValence.send(
                msg.getParticipant().getMail(),
                msg.getParticipant().getNickname(),
                "Welcome in MicroChat",
                String.format("Hi %s,\nYou're joining the chat hashtag #%s.\n\nEnjoy,\nMicroChat Administrator",msg.getParticipant().getNickname(),msg.getChat().getHashtag()));
    }

    @StreamListener(target = MQBinding.UNSUBSCRIPTION)
    public void processUnsubscription(MicroChatMessage msg) {
        mailValence.send(
                msg.getParticipant().getMail(),
                msg.getParticipant().getNickname(),
                "See you in MicroChat",
                String.format("Hi %s,\nYou're leaving the chat hashtag #%s.\n\nBye,\nMicroChat Administrator",msg.getParticipant().getNickname(),msg.getChat().getHashtag()));
    }
}
