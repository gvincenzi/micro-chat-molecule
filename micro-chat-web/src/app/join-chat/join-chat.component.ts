import { Component, OnInit } from '@angular/core';
import {FormBuilder} from '@angular/forms';
import {MicrochatService} from '../microchat.service';
import {Participant} from '../model/participant';
import {Observable} from 'rxjs';
import {Chat} from '../model/chat';

@Component({
  selector: 'app-join-chat',
  templateUrl: './join-chat.component.html',
  styleUrls: ['./join-chat.component.css']
})
export class JoinChatComponent implements OnInit {
  participants: Observable<Participant[]>;
  chat: Chat;
  participant: Participant;
  joined: Boolean;

  joinForm = this.formBuilder.group({
    mail: '',
    nickname: '',
    hashtag: ''
  });

  constructor(private formBuilder: FormBuilder, private microchatService: MicrochatService) { }

  ngOnInit(): void {
  }

  onSubmit(): void {
    this.participant = new Participant(this.joinForm.value.mail,this.joinForm.value.nickname);
    this.participants = this.microchatService.joinChat(this.participant, this.joinForm.value.hashtag);
    this.participants.subscribe(res => {console.info(res); this.chat = new Chat(this.joinForm.value.hashtag); this.joined = true;});
  }

  onLeave() {
      this.microchatService.leaveChat(this.participant,this.chat.hashtag).toPromise().then(s => {this.joinForm.reset(); this.participant = null; this.chat = null; this.joined = false;});
  }

}
