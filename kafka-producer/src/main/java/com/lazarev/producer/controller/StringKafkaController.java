package com.lazarev.producer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class StringKafkaController {
    private static final String STRING_TOPIC_RESULT = "kafka-string-result-topic";

    @KafkaListener(topics = STRING_TOPIC_RESULT)
    public void consumeStringResult(String value) {
        log.info("Received result from consumer: " + value);
    }
}
