package ru.mironov.springaop.dto;

public record TimeTrackDto(String className, String methodName, long time) {
}
