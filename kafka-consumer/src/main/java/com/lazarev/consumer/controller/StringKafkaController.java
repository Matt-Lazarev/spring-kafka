package com.lazarev.consumer.controller;

import com.lazarev.model.dto.MessageDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class StringKafkaController {
    private static final String STRING_TOPIC = "json-topic";

    @KafkaListener(topics = STRING_TOPIC)
    public void consumeString(MessageDto message) {
        log.info("Consumed from producer: " + message);

        String result = "[result] " + message.text().toUpperCase();
        log.info("result from consumer: " + result);
    }
}
