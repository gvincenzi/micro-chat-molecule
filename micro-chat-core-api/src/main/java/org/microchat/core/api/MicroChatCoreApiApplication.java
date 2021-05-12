package org.microchat.core.api;

import org.microchat.core.event.broker.binding.MQBinding;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableBinding(MQBinding.class)
@EntityScan("org.microchat.core.model.entity")
@EnableJpaRepositories("org.microchat.core.model.repository")
@SpringBootApplication(scanBasePackages={"org.microchat.core.api","org.microchat.core.domain","org.microchat.core.model","org.microchat.core.event.broker"})
public class MicroChatCoreApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(MicroChatCoreApiApplication.class, args);
    }

}
