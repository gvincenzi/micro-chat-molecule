import { MicroChatEventMessage } from './micro-chat-event-message';
import {Chat} from './chat';
import {Participant} from './participant';

describe('MicroChatEventMessage', () => {
  it('should create an instance', () => {
    let text: string;
    let chat : Chat;
    let participant : Participant;
    let eventType: string;
    expect(new MicroChatEventMessage(eventType, participant, chat, text)).toBeTruthy();
  });
});
