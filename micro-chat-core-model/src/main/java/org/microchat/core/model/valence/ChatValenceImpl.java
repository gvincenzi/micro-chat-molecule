package org.microchat.core.model.valence;

import org.microchat.core.domain.entity.Chat;
import org.microchat.core.domain.entity.ChatMessage;
import org.microchat.core.domain.entity.Participant;
import org.microchat.core.domain.valence.ChatValence;
import org.microchat.core.model.entity.ChannelType;
import org.microchat.core.model.entity.Message;
import org.microchat.core.model.entity.User;
import org.microchat.core.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class ChatValenceImpl implements ChatValence {
    @Autowired
    UserRepository userRepository;

    @Override
    public Set<Participant> joinChat(Participant participant, Chat chat) {
        User user = new User();
        user.setChannelType(ChannelType.WEB);
        user.setChannelUUID("WEB#"+participant.getNickname());
        user.setCode(chat.getHashtag());
        user.setNickname(participant.getNickname());
        user.setUserId(participant.getMail());
        userRepository.save(user);

        Set<User> byCode = userRepository.findByCode(chat.getHashtag());
        Set<Participant> participants = new HashSet<>(byCode.size());
        for (User userByCode : byCode) {
            participants.add(new Participant(userByCode.getNickname(),userByCode.getUserId()));
        }

        return participants;
    }

    @Override
    public void leaveChat(Participant participant, Chat chat) {
        Optional<User> byId = userRepository.findById(participant.getMail());
        if(byId.isPresent()){
            userRepository.deleteById(byId.get().getUserId());
        }
    }

    @Override
    public void sendMessage(ChatMessage chatMessage) {
        Optional<User> byId = userRepository.findById(chatMessage.getAuthor().getMail());
        if(byId.isPresent()){
            Message message = new Message();
            message.setAuthor(byId.get());
            message.setText(chatMessage.getText());
        }

    }
}
