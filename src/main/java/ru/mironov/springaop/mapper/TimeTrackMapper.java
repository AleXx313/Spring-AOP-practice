package ru.mironov.springaop.mapper;

import ru.mironov.springaop.dto.TimeTrackDto;
import ru.mironov.springaop.model.TimeTrack;

public class TimeTrackMapper {

    public static TimeTrack dtoToModel(TimeTrackDto timeTrackDto){
        TimeTrack timeTrack = new TimeTrack();
        timeTrack.setClassName(timeTrackDto.className());
        timeTrack.setMethodName(timeTrackDto.methodName());
        timeTrack.setTime(timeTrackDto.time());
        return timeTrack;
    }

    public static TimeTrackDto modelToDto(TimeTrack timeTrack){
        return new TimeTrackDto(timeTrack.getClassName(), timeTrack.getMethodName(), timeTrack.getTime());
    }
}
