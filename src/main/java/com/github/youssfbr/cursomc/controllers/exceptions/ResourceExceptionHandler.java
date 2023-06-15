package com.github.youssfbr.cursomc.controllers.exceptions;

import com.github.youssfbr.cursomc.services.exceptions.DatabaseException;
import com.github.youssfbr.cursomc.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound (
            ResourceNotFoundException e,
            HttpServletRequest request)
    {

        HttpStatus status = HttpStatus.NOT_FOUND;

        StandardError error = StandardError.builder()
                .status(status.value())
                .error("Resource not found.")
                .message(e.getMessage())
                .path(request.getRequestURI())
                .build();

        return new ResponseEntity<>(error, status);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> databaseException (
            DatabaseException e,
            HttpServletRequest request)
    {
        HttpStatus status = HttpStatus.BAD_REQUEST;

        StandardError error = StandardError.builder()
                .status(status.value())
                .error("Database exception")
                .message(e.getMessage())
                .path(request.getRequestURI())
                .build();

        return new ResponseEntity<>(error, status);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> validation (
            MethodArgumentNotValidException e,
            HttpServletRequest request)
    {
        HttpStatus status = HttpStatus.BAD_REQUEST;

        ValidationError err = new ValidationError(
                status.value(),
                "Erro de validação",
                "Um ou mais campos estão errados.",
                request.getRequestURI());

        for (FieldError x : e.getBindingResult().getFieldErrors()) {
            err.addErrors(x.getField(), x.getDefaultMessage());
        }

        return new ResponseEntity<>(err, status);
    }

}
