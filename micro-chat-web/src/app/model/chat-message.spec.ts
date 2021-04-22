import { ChatMessage } from './chat-message';
import {Chat} from './chat';
import {Participant} from './participant';

describe('ChatMessage', () => {
  it('should create an instance', () => {
    let text: string;
    let chat : Chat;
    let author : Participant;
    expect(new ChatMessage(text, chat, author)).toBeTruthy();
  });
});
