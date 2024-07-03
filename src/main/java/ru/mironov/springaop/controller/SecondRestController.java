package ru.mironov.springaop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mironov.springaop.annotation.TrackAsyncTime;

@RestController
@RequestMapping("second")
public class SecondRestController {

    @GetMapping("hello")
    @TrackAsyncTime
    public String sayHello() {
        return "Hello!";
    }

    @GetMapping("hello-world")
    @TrackAsyncTime
    public String sayHelloWorld() {
        return "Hello World!";
    }

    @GetMapping("bye")
    @TrackAsyncTime
    public String sayBye() {
        return "Bye!";
    }
}
