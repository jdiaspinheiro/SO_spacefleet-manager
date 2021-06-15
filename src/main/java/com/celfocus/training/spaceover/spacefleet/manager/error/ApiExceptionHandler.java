package com.celfocus.training.spaceover.spacefleet.manager.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;
import java.time.ZonedDateTime;

@Slf4j
@ControllerAdvice
public class ApiExceptionHandler {

    private ResponseEntity<ApiErrorResponse> buildApiExceptionResponse(HttpStatus status, Exception e, String code) {
        log.error("Unexpected Exception Occurred: {}", e.getMessage());
        ApiErrorResponse apiErrorResponse = ApiErrorResponse.builder()
                .code(code)
                .status(status.value())
                .message(e.getMessage())
                .reason(status.getReasonPhrase())
                .referenceError("https://stackoverflow.com/" + code)
                .timeStamp(ZonedDateTime.now())
                .build();
        return new ResponseEntity<>(apiErrorResponse, status);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> handleInternalServerError(Exception e) {
        return buildApiExceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR, e, "ERR03");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErrorResponse> handleBadRequest(MethodArgumentNotValidException e) {
        return buildApiExceptionResponse(HttpStatus.BAD_REQUEST, e, "ERR03");
    }

    @ExceptionHandler(value = {EntityNotFoundException.class, EmptyResultDataAccessException.class})
    public ResponseEntity<ApiErrorResponse> handleNotFound(Exception e) {
        return buildApiExceptionResponse(HttpStatus.NOT_FOUND, e, "ERR03");
    }
}
