package ru.mironov.springaop.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import ru.mironov.springaop.util.enums.AggregationType;
@Schema(description = "Модель данных со статистикой")
public record TimeTrackAggregationData (
        @Schema(description = "Данные", example = "999999")
        double data,
        @Schema(description = "Имя класса", example = "SomeClass")
        String className,
        @Schema(description = "Имя метода", example = "someMethod")
        String methodName,
        @Schema(description = "Тип агрегации", example = "[SUM, AVG, MAX]")
        AggregationType type){
}
