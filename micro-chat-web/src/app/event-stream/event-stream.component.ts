import {Component, OnDestroy, OnInit} from '@angular/core';
import {IMqttMessage, MqttService} from "ngx-mqtt";
import {Subscription} from "rxjs";

@Component({
    selector: 'app-event-stream',
    templateUrl: './event-stream.component.html',
    styleUrls: ['./event-stream.component.css']
})
export class EventStreamComponent implements OnInit,OnDestroy {
    events: any[];
    private subscription: Subscription;

    constructor(private _mqttService: MqttService) {
        this.subscription = this._mqttService.observe('microchatSubscriptionChannel').subscribe((message: IMqttMessage) => {
            console.info(message.payload.toString());
        });
        this.subscription = this._mqttService.observe('microchatUnsubscriptionChannel').subscribe((message: IMqttMessage) => {
            console.info(message.payload.toString());
        });
        this.subscription = this._mqttService.observe('microchatMessageChannel').subscribe((message: IMqttMessage) => {
            console.info(message.payload.toString());
        });
    }

    public unsafePublish(topic: string, message: string): void {
        this._mqttService.unsafePublish(topic, message, {qos: 1, retain: true});
    }

    public ngOnDestroy() {
        this.subscription.unsubscribe();
    }

    ngOnInit(): void {
    }
}
