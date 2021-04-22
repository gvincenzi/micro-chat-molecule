package org.microchat.api.controller;

import lombok.extern.java.Log;
import org.microchat.domain.entity.Chat;
import org.microchat.domain.entity.ChatMessage;
import org.microchat.domain.entity.Participant;
import org.microchat.domain.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.Set;

@Log
@RestController
public class MicrochatController {
    @Autowired
    private ChatService chatService;

    @PostMapping("/chat/{hashtag}/join")
    public ResponseEntity<Set<Participant>> joinChat(@RequestBody @NotNull Participant participant, @PathVariable @NotNull String hashtag) {
        return new ResponseEntity<>(chatService.joinChat(participant, new Chat(hashtag)), HttpStatus.OK);
    }

    @PostMapping("/chat/{hashtag}/leave")
    public ResponseEntity<Participant> leaveChat(@RequestBody @NotNull Participant participant, @PathVariable @NotNull String hashtag) {
        chatService.leaveChat(participant, new Chat(hashtag));
        return new ResponseEntity<>(participant, HttpStatus.OK);
    }

    @PostMapping("/message")
    public ResponseEntity<ChatMessage> postMessage(@RequestBody @NotNull ChatMessage chatMessage) {
        chatService.sendMessage(chatMessage);
        return new ResponseEntity<>(chatMessage, HttpStatus.OK);
    }
}
