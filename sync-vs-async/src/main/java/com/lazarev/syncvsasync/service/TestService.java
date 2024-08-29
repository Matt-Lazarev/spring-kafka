package com.lazarev.syncvsasync.service;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @SneakyThrows
    public String getString() {
        Thread.sleep(10_000);

        return "Test string";
    }
}
