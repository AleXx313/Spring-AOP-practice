package ru.mironov.springaop.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.time.LocalDateTime;

@RestControllerAdvice
@Slf4j
public class ErrorHandler {
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidExceptions(final MethodArgumentNotValidException e) {
        log.info("Получен статус 400 BadRequest {}", e.getMessage());
        ErrorResponse response = new ErrorResponse(
                "Передан некорректный объект! --MethodArgumentNotValid--",
                e.getMessage(),
                HttpStatus.BAD_REQUEST.name(),
                LocalDateTime.now());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({NoResourceFoundException.class})
    public ResponseEntity<ErrorResponse> handleNoResourceFoundExceptions(final NoResourceFoundException e) {
        log.info("Получен статус 404 Not Found {}", e.getMessage());
        ErrorResponse response = new ErrorResponse(
                "Ресурс не найден! --NoResourceFoundException--",
                e.getMessage(),
                HttpStatus.NOT_FOUND.name(),
                LocalDateTime.now());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({JoinPointProceedException.class})
    public ResponseEntity<ErrorResponse> handleJoinPointProceedExceptions(final JoinPointProceedException e) {
        log.info("Получен статус 400 BadRequest {}", e.getMessage());
        ErrorResponse response = new ErrorResponse(
                "Ошибка при выполнении метода в точке среза! --JoinPointProceedException--",
                e.getMessage(),
                HttpStatus.BAD_REQUEST.name(),
                LocalDateTime.now());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({Throwable.class})
    public ResponseEntity<ErrorResponse> handleNotSpecializedException(final Throwable e) {
        log.info("Получен статус 500 InternalServerError {}", e.getMessage());
        ErrorResponse response = new ErrorResponse(
                "Неизвестная ошибка!",
                e.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR.name(),
                LocalDateTime.now());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
