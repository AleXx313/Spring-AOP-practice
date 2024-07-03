package ru.mironov.springaop.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mironov.springaop.annotation.TrackAsyncTime;

@RestController
@RequestMapping("first")
@Tag(
        name = "Тестовый контроллер № 1",
        description = "Тестовый контроллер содержащий методы помеченные аннотацией TrackAsyncTime")
public class FirstRestController {

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
