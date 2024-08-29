package com.lazarev.syncvsasync.controller;

import com.lazarev.syncvsasync.service.TestService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/test")
public class TestController {
    private final TestService testService;

    //          TaskId  Result
    private Map<String, String> results = new HashMap<>();

    @GetMapping
    @SneakyThrows
    public String getString() {
        return testService.getString();
    }

    @GetMapping("/async")
    public String getStringAsync() {
        String taskId = UUID.randomUUID().toString();
        new Thread(
                () -> {
                    String result = testService.getString();
                    results.put(taskId, result);
                }
        ).start();
        return taskId;
    }

    @GetMapping("/async/check-status/{taskId}")
    public String getStringAsyncCheckStatus(@PathVariable String taskId) {
        return results.getOrDefault(taskId, "[Result is not ready yet]");
    }
}
