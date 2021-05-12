package org.microchat.notification.email.binding;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface MQBinding {
    String SUBSCRIPTION = "subscriptionChannel";
    String UNSUBSCRIPTION = "unsubscriptionChannel";

    @Input(SUBSCRIPTION)
    SubscribableChannel subscriptionChannel();

    @Input(UNSUBSCRIPTION)
    SubscribableChannel unsubscriptionChannel();
}
