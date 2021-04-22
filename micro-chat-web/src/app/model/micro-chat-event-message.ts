import {Participant} from './participant';
import {Chat} from './chat';

export class MicroChatEventMessage {
    constructor(
        public eventType: string,
        public participant: Participant,
        public chat: Chat,
        public text: string
        ) {
    }
}
