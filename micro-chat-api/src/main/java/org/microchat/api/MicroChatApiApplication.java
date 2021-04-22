package org.microchat.api;

import org.microchat.event.broker.binding.MQBinding;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableBinding(MQBinding.class)
@EntityScan("org.microchat.model.entity")
@EnableJpaRepositories("org.microchat.model.repository")
@SpringBootApplication(scanBasePackages={"org.microchat.api","org.microchat.domain","org.microchat.model","org.microchat.event.broker"})
public class MicroChatApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(MicroChatApiApplication.class, args);
    }

}
