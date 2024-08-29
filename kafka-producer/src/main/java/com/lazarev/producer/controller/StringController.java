package com.lazarev.producer.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/string")
public class StringController {
    private static final String STRING_TOPIC = "kafka-string-topic";

    private final KafkaTemplate<Integer, String> kafkaTemplate;

    // /api/string?message=text
    @GetMapping
    public String sendMessageToKafka(@RequestParam String message) {
        kafkaTemplate.send(STRING_TOPIC, message);

        log.info("Message {} sent to Kafka in topic {}", message, STRING_TOPIC);

        return "Message sent to Kafka in topic " + STRING_TOPIC;
    }
}
