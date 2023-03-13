package com.example.demo.test.interfaces.test;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class TestController {

    @GetMapping( "/test")
    public String getFrequency(
            @RequestParam("testId") String testId) {

        log.info("log : " + testId);

        return "Hello " + testId;
    }

}