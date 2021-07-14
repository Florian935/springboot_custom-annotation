package com.florian935.customannotation.controller;

import com.florian935.customannotation.annotation.LogExecutionTime;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

@RestController
@RequestMapping("/api/v1.0")
public class HelloController {

    @GetMapping(path = "/hello", produces = TEXT_PLAIN_VALUE)
    @ResponseStatus(OK)
    @LogExecutionTime
    @SneakyThrows
    String sayHello() {

        Thread.sleep(1000);

        return "Hello !";
    }
}
