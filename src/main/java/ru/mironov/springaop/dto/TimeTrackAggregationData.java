package ru.mironov.springaop.dto;

import ru.mironov.springaop.util.enums.AggregationType;

public record TimeTrackAggregationData (double data, String className, String methodName, AggregationType type){
}
