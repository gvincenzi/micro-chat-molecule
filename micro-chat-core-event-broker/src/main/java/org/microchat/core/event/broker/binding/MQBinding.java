package org.microchat.core.event.broker.binding;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface MQBinding {
    String SUBSCRIPTION = "subscriptionChannel";
    String UNSUBSCRIPTION = "unsubscriptionChannel";
    String MESSAGE = "messageChannel";

    @Output(SUBSCRIPTION)
    MessageChannel subscriptionChannel();

    @Output(UNSUBSCRIPTION)
    MessageChannel unsubscriptionChannel();

    @Output(MESSAGE)
    MessageChannel messageChannel();
}
