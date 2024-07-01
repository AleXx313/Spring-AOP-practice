package ru.mironov.springaop.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mironov.springaop.dto.TimeTrackDto;
import ru.mironov.springaop.mapper.TimeTrackMapper;
import ru.mironov.springaop.model.TimeTrack;
import ru.mironov.springaop.repository.TimeTrackRepository;
import ru.mironov.springaop.util.Constants;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class DefaultTimeTrackService implements TimeTrackService {

    private TimeTrackRepository timeTrackRepository;

    @Override
    public void save(TimeTrackDto dto) {
        TimeTrack timeTrack = TimeTrackMapper.dtoToModel(dto);
        timeTrack.setTimestamp(LocalDateTime.now());
        timeTrackRepository.save(timeTrack);
    }

    @Override
    public Integer getAverageTimeTrack(String className, String methodName,  LocalDateTime rangeStart, LocalDateTime rangeEnd){
        if (rangeStart == null) {
            rangeStart = Constants.MIN_DATE;
        }
        if (rangeEnd == null) {
            rangeEnd = LocalDateTime.now();
        }
        if (className.isBlank() && methodName.isBlank()){
            return timeTrackRepository.getAverage(rangeStart, rangeEnd);
        } else if (className.isBlank()){
            return timeTrackRepository.getAverageByMethodName(methodName, rangeStart, rangeEnd);
        } else if (methodName.isBlank()){
            return timeTrackRepository.getAverageByClassName(className, rangeStart, rangeEnd);
        } else {
            return timeTrackRepository.getAverageByClassNameAndMethodName(className, methodName, rangeStart, rangeEnd);
        }
    }

    @Override
    public Long getTotalTimeTracked(String className, String methodName, LocalDateTime rangeStart, LocalDateTime rangeEnd) {
        if (rangeStart == null) {
            rangeStart = Constants.MIN_DATE;
        }
        if (rangeEnd == null) {
            rangeEnd = LocalDateTime.now();
        }
        if (className.isBlank() && methodName.isBlank()){
            return timeTrackRepository.getSum(rangeStart, rangeEnd);
        } else if (className.isBlank()){
            return timeTrackRepository.getSumByMethodName(methodName, rangeStart, rangeEnd);
        } else if (methodName.isBlank()){
            return timeTrackRepository.getSumByClassName(className, rangeStart, rangeEnd);
        } else {
            return timeTrackRepository.getSumByClassNameAndMethodName(className, methodName, rangeStart, rangeEnd);
        }
    }

    @Override
    public Integer getMaxTimeTrack(String className, String methodName, LocalDateTime rangeStart, LocalDateTime rangeEnd) {
        if (rangeStart == null) {
            rangeStart = Constants.MIN_DATE;
        }
        if (rangeEnd == null) {
            rangeEnd = LocalDateTime.now();
        }
        if (className.isBlank() && methodName.isBlank()){
            return timeTrackRepository.getMax(rangeStart, rangeEnd);
        } else if (className.isBlank()){
            return timeTrackRepository.getMaxByMethodName(methodName, rangeStart, rangeEnd);
        } else if (methodName.isBlank()){
            return timeTrackRepository.getMaxByClassName(className, rangeStart, rangeEnd);
        } else {
            return timeTrackRepository.getMaxByClassNameAndMethodName(className, methodName, rangeStart, rangeEnd);
        }
    }
}
