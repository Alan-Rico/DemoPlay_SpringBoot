package com.alan.play.web.exception;

import com.alan.play.domain.exception.MovieAlreadyExistsException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHadler {
    @ExceptionHandler(MovieAlreadyExistsException.class)
    public ResponseEntity<Error> handleException(MovieAlreadyExistsException exception) {
        Error error = new Error("movie-already-exists", exception.getMessage());
        return ResponseEntity.badRequest().body(error);
    }
}
