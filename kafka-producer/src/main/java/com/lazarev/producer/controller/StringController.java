package com.lazarev.producer.controller;

import com.lazarev.model.dto.MessageDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/string")
public class StringController {
    private static final String STRING_TOPIC = "json-topic";

    private final KafkaTemplate<Integer, Object> kafkaTemplate;

    @PostMapping
    public String sendMessageToKafka(@RequestBody MessageDto message) {
        kafkaTemplate.send(STRING_TOPIC, message.id(), message);

        log.info("Message {} sent to Kafka in topic {}", message, STRING_TOPIC);

        return "Message sent to Kafka in topic " + STRING_TOPIC;
    }
}
