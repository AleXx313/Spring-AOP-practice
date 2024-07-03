package ru.mironov.springaop.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import ru.mironov.springaop.util.Constants;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private String reason;
    private String message;
    private String status;
    @JsonFormat(pattern = Constants.DATE_PATTERN)
    private LocalDateTime timestamp;
}
