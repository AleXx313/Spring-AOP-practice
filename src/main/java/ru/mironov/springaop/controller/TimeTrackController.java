package ru.mironov.springaop.controller;


import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.mironov.springaop.service.TimeTrackService;
import ru.mironov.springaop.util.Constants;

import java.time.LocalDateTime;

@RestController
@RequestMapping("time-track")
@RequiredArgsConstructor
public class TimeTrackController {

    private final TimeTrackService timeTrackService;

    @GetMapping("sum")
    public Long getTotalTimeTracked(@RequestParam(required = false, defaultValue = "") String className,
                                    @RequestParam(required = false, defaultValue = "") String methodName,
                                    @RequestParam(required = false) @DateTimeFormat(pattern = Constants.DATE_PATTERN) LocalDateTime rangeStart,
                                    @RequestParam(required = false) @DateTimeFormat(pattern = Constants.DATE_PATTERN) LocalDateTime rangeEnd) {
        return timeTrackService.getTotalTimeTracked(className, methodName, rangeStart, rangeEnd);
    }

    @GetMapping("avg")
    public Integer getAverageTimeTracked(@RequestParam(required = false, defaultValue = "") String className,
                                     @RequestParam(required = false, defaultValue = "") String methodName,
                                     @RequestParam(required = false) @DateTimeFormat(pattern = Constants.DATE_PATTERN) LocalDateTime rangeStart,
                                     @RequestParam(required = false) @DateTimeFormat(pattern = Constants.DATE_PATTERN) LocalDateTime rangeEnd) {
        return timeTrackService.getAverageTimeTrack(className, methodName, rangeStart, rangeEnd);
    }

    @GetMapping("max")
    public Integer getMaxTimeTracked(@RequestParam(required = false, defaultValue = "") String className,
                                     @RequestParam(required = false, defaultValue = "") String methodName,
                                     @RequestParam(required = false) @DateTimeFormat(pattern = Constants.DATE_PATTERN) LocalDateTime rangeStart,
                                     @RequestParam(required = false) @DateTimeFormat(pattern = Constants.DATE_PATTERN) LocalDateTime rangeEnd) {
        return timeTrackService.getMaxTimeTrack(className, methodName, rangeStart, rangeEnd);
    }
}
