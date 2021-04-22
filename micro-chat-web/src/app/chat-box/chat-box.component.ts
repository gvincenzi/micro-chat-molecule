import {Component, ElementRef, Input, OnInit, ViewChild} from '@angular/core';
import {Participant} from '../model/participant';
import {FormBuilder} from '@angular/forms';
import {IMqttMessage, MqttService} from 'ngx-mqtt';
import {ChatMessage} from '../model/chat-message';
import {Chat} from '../model/chat';
import {MicroChatEventMessage} from '../model/micro-chat-event-message';
import {MicrochatService} from '../microchat.service';

@Component({
  selector: 'app-chat-box',
  templateUrl: './chat-box.component.html',
  styleUrls: ['./chat-box.component.css']
})
export class ChatBoxComponent implements OnInit {
  @ViewChild('autoScroll', {static: true}) private myScrollContainer: ElementRef;
  @Input('chatTitle') chatTitle: string;
  @Input('chatSubTitle') chatSubTitle: string;
  @Input('participant') participant: Participant;
  @Input('hashtag') hashtag: string;
  isModalActive = false;

  messageForm = this.formBuilder.group({
    text: ''
  });

  messages: ChatMessage[] = [];
  chat: Chat;

  constructor(private formBuilder: FormBuilder, private mqttService: MqttService, private microchatService: MicrochatService) {
  }

  ngOnInit(): void {
    this.chat = new Chat(this.hashtag);

    this.mqttService.observe('microchatMessageChannel').subscribe((message: IMqttMessage) => {
      let msg: MicroChatEventMessage = JSON.parse(message.payload.toString());
      if(msg.chat.hashtag == this.chat.hashtag){
        let chatMessage = new ChatMessage(msg.text, msg.chat, msg.participant);
        this.messages.push(chatMessage);
      }
    });
    this.mqttService.observe('microchatSubscriptionChannel').subscribe((message: IMqttMessage) => {
      let msg: MicroChatEventMessage = JSON.parse(message.payload.toString());
      if(msg.chat.hashtag == this.chat.hashtag && msg.participant.mail != this.participant.mail){
        this.messages.push(new ChatMessage("Joined the room", msg.chat, msg.participant));
      }
    });
    this.mqttService.observe('microchatUnsubscriptionChannel').subscribe((message: IMqttMessage) => {
      let msg: MicroChatEventMessage = JSON.parse(message.payload.toString());
      if(msg.chat.hashtag == this.chat.hashtag){
        this.messages.push(new ChatMessage("Left the room", msg.chat, msg.participant));
      }
    });
  }

  showDialog() {
    this.isModalActive = true;
    let modal_t = document.getElementById('chat_modal');
    modal_t.classList.remove('hidden-chat');
    modal_t.classList.add('show-chat');
  }

  closeDialog() {
    this.isModalActive = false;
    let modal_t = document.getElementById('chat_modal');
    modal_t.classList.remove('show-chat');
    modal_t.classList.add('hidden-chat');
  }

  onSubmit(): void {
    let chatMessage = new ChatMessage(this.messageForm.value.text,this.chat,this.participant);
    this.microchatService.postMessage(chatMessage).subscribe(
        () => this.messageForm.reset()
    );
  }

}
