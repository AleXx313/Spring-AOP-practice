package ru.mironov.springaop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class SpringAopApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAopApplication.class, args);
        log.info("++++++++++++++++++++ Я ЛОГИРУЮСЬ ++++++++++++++++++++");
    }
}
