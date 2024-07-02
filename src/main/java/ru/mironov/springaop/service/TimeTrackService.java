package ru.mironov.springaop.service;

import ru.mironov.springaop.dto.TimeTrackAggregationData;
import ru.mironov.springaop.dto.TimeTrackDto;

import java.time.LocalDateTime;
import java.util.List;

public interface TimeTrackService {

    void save(TimeTrackDto dto);

    List<TimeTrackAggregationData> getAverageTimeTrack(String className, String methodName, LocalDateTime rangeStart, LocalDateTime rangeEnd);

    List<TimeTrackAggregationData> getTotalTimeTracked(String className, String methodName, LocalDateTime rangeStart, LocalDateTime rangeEnd);

    List<TimeTrackAggregationData> getMaxTimeTrack(String className, String methodName, LocalDateTime rangeStart, LocalDateTime rangeEnd);
}
