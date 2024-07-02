package ru.mironov.springaop.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.mironov.springaop.dto.TimeTrackAggregationData;
import ru.mironov.springaop.service.TimeTrackService;
import ru.mironov.springaop.util.Constants;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("time-track")
@RequiredArgsConstructor
@Tag(
        name="Контроллер для сбора статистики",
        description="Контроллер для сбора статистики времени выполнения методов приложения аннотированных аннотацией TrackAsyncTime")
public class TimeTrackController {

    private final TimeTrackService timeTrackService;

    @Operation(
            summary = "Общее время выполнения",
            description = "Позволяет получить данные об общем времени выполнения метода"
    )
    @GetMapping("sum")
    public List<TimeTrackAggregationData> getTotalTimeTracked(
            @RequestParam(required = false, defaultValue = "")
            @Parameter(description = "Название класса") String className,
            @RequestParam(required = false, defaultValue = "")
            @Parameter(description = "Название метода") String methodName,
            @RequestParam(required = false) @DateTimeFormat(pattern = Constants.DATE_PATTERN)
            @Parameter(description = "Начало отрезка") LocalDateTime rangeStart,
            @RequestParam(required = false) @DateTimeFormat(pattern = Constants.DATE_PATTERN)
            @Parameter(description = "Конец отрезка") LocalDateTime rangeEnd) {
        return timeTrackService.getTotalTimeTracked(className, methodName, rangeStart, rangeEnd);
    }
    @Operation(
            summary = "Среднее время выполнения",
            description = "Позволяет получить данные о среднем времени выполнения метода"
    )
    @GetMapping("avg")
    public List<TimeTrackAggregationData> getAverageTimeTracked(
            @RequestParam(required = false, defaultValue = "")
            @Parameter(description = "Название класса") String className,
            @RequestParam(required = false, defaultValue = "")
            @Parameter(description = "Название метода") String methodName,
            @RequestParam(required = false) @DateTimeFormat(pattern = Constants.DATE_PATTERN)
            @Parameter(description = "Начало отрезка") LocalDateTime rangeStart,
            @RequestParam(required = false) @DateTimeFormat(pattern = Constants.DATE_PATTERN)
            @Parameter(description = "Конец отрезка") LocalDateTime rangeEnd) {
        return timeTrackService.getAverageTimeTrack(className, methodName, rangeStart, rangeEnd);
    }

    @Operation(
            summary = "Максимальное время выполнения",
            description = "Позволяет получить данные о максимальном времени выполнения метода"
    )
    @GetMapping("max")
    public List<TimeTrackAggregationData> getMaxTimeTracked(
            @RequestParam(required = false, defaultValue = "")
            @Parameter(description = "Название класса") String className,
            @RequestParam(required = false, defaultValue = "")
            @Parameter(description = "Название метода") String methodName,
            @RequestParam(required = false) @DateTimeFormat(pattern = Constants.DATE_PATTERN)
            @Parameter(description = "Начало отрезка") LocalDateTime rangeStart,
            @RequestParam(required = false) @DateTimeFormat(pattern = Constants.DATE_PATTERN)
            @Parameter(description = "Конец отрезка") LocalDateTime rangeEnd) {
        return timeTrackService.getMaxTimeTrack(className, methodName, rangeStart, rangeEnd);
    }
}
