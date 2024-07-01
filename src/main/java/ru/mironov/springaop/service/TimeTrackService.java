package ru.mironov.springaop.service;

import ru.mironov.springaop.dto.TimeTrackDto;

import java.time.LocalDateTime;

public interface TimeTrackService {

    void save(TimeTrackDto dto);

    Integer getAverageTimeTrack(String className, String methodName,  LocalDateTime rangeStart, LocalDateTime rangeEnd);

    Long getTotalTimeTracked(String className, String methodName,  LocalDateTime rangeStart, LocalDateTime rangeEnd);

    Integer getMaxTimeTrack(String className, String methodName,  LocalDateTime rangeStart, LocalDateTime rangeEnd);
}
