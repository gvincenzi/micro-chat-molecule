package org.microchat.notification.api;

import org.microchat.notification.email.binding.MQBinding;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableEurekaClient
@EnableBinding(MQBinding.class)
@SpringBootApplication(scanBasePackages={"org.microchat.notification.api","org.microchat.notification.domain","org.microchat.notification.email"})
public class MicroChatNotificationApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(MicroChatNotificationApiApplication.class, args);
    }

}
