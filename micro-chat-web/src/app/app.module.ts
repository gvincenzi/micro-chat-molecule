import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {RouterModule} from '@angular/router';
import {ReactiveFormsModule} from '@angular/forms';
import {AppComponent} from './app.component';
import {IMqttServiceOptions, MqttModule} from "ngx-mqtt";
import { environment as env } from '../environments/environment';
import { EventStreamComponent } from './event-stream/event-stream.component';
import { TopBarComponent } from './top-bar/top-bar.component';
import {HttpClientModule} from '@angular/common/http';
import { JoinChatComponent } from './join-chat/join-chat.component';
import {MatCardModule} from '@angular/material/card';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {MatButtonModule} from '@angular/material/button';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { ChatBoxComponent } from './chat-box/chat-box.component';
import {MatIconModule} from '@angular/material/icon';
import {MatTableModule} from '@angular/material/table';

const MQTT_SERVICE_OPTIONS: IMqttServiceOptions = {
    hostname: env.mqtt.server,
    port: env.mqtt.port,
    protocol: (env.mqtt.protocol === "wss") ? "wss" : "ws",
    path: env.mqtt.path,
    username: env.mqtt.username,
    password: env.mqtt.password
};

@NgModule({
    imports: [
        BrowserModule,
        ReactiveFormsModule,
        RouterModule.forRoot([
            {path: 'events', component: EventStreamComponent},
            {path: 'join', component: JoinChatComponent},
        ]),
        MqttModule.forRoot(MQTT_SERVICE_OPTIONS),
        HttpClientModule,
        MatCardModule,
        MatFormFieldModule,
        MatInputModule,
        MatButtonModule,
        BrowserAnimationsModule,
        MatIconModule,
        MatTableModule
    ],
  declarations: [
    AppComponent,
    EventStreamComponent,
    TopBarComponent,
    JoinChatComponent,
    ChatBoxComponent,

  ],
  bootstrap: [
    AppComponent
  ]
})
export class AppModule { }


/*
Copyright Google LLC. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at https://angular.io/license
*/
