package ru.mironov.springaop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mironov.springaop.annotation.TrackAsyncTime;
import ru.mironov.springaop.annotation.TrackTime;

@RestController
@RequestMapping("hello")
public class SimpleRestController {

    @GetMapping
    @TrackAsyncTime
    public String sayHello() {
        return "Hello!";
    }
}
