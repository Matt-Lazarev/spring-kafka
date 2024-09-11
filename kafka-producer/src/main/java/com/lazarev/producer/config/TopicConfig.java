package com.lazarev.producer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicConfig {

    @Bean
    public NewTopic topic() {
        return new NewTopic("json-topic", 2, (short) 1);
    }
}
