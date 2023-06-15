package com.github.youssfbr.cursomc.controllers.exceptions;

import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(of = "id")
public class ValidationError extends StandardError {

    private List<FieldMessage> errors = new ArrayList<>();
    public ValidationError(Integer status, String error, String message, String path) {
        super(status, error, message, path);
    }

    public void addErrors(String fieldName, String message) {
        errors.add(new FieldMessage(fieldName, message));
    }

    public List<FieldMessage> getErrors() {
        return errors;
    }



}
