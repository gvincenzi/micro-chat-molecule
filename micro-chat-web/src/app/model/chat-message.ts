import {Chat} from './chat';
import {Participant} from './participant';

export class ChatMessage {
    constructor(
        public text: string,
        public chat : Chat,
        public author : Participant
    ){}
}
