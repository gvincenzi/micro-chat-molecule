import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {map} from 'rxjs/operators';
import {Participant} from './model/participant';
import {ChatMessage} from './model/chat-message';

@Injectable({
    providedIn: 'root'
})
export class MicrochatService {
    private readonly URL = 'http://localhost:4200/api';

    constructor(private http: HttpClient) {
    }

    joinChat(participant: Participant, hashtag: string): Observable<Participant[]> {
        let completeURL = this.URL + '/chat/' + hashtag + '/join';
        return this.http
            .post(completeURL, participant)
            .pipe(
                map((data: any[]) =>
                    data.map(
                        (item: any) =>
                            new Participant(item.mail, item.nickname)
                    )
                )
            );
        ;
    }

    leaveChat(participant: Participant, hashtag: string): Observable<any> {
        let completeURL = this.URL + '/chat/' + hashtag + '/leave';
        return this.http
            .post(completeURL, participant);
    }

    postMessage(chatMessage: ChatMessage): Observable<any> {
        let completeURL = this.URL + '/message';
        return this.http
            .post(completeURL, chatMessage);
    }
}
