package com.florian935.customannotation.controller;

import com.florian935.customannotation.annotation.logbefore.LogBefore;
import com.florian935.customannotation.annotation.logexecutiontime.LogExecutionTime;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

@RestController
@RequestMapping("/api/v1.0")
@Slf4j
public class HelloController {

    @GetMapping(path = "/hello", produces = TEXT_PLAIN_VALUE)
    @ResponseStatus(OK)
    @LogExecutionTime
    @SneakyThrows
    String sayHello() {

        Thread.sleep(1000);

        return "Hello !";
    }

    @GetMapping(path = "/hello/before/{name}", produces = TEXT_PLAIN_VALUE)
    @ResponseStatus(OK)
    @LogBefore
    String sayHelloBefore(@PathVariable String name) {

        log.info("This message is printed after the message of the annotation");

        return String.format("Hello %s !", name);
    }
}
