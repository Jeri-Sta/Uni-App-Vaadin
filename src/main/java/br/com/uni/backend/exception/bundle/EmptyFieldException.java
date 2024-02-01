package br.com.uni.backend.exception.bundle;

import br.com.uni.backend.exception.UniException;

public class EmptyFieldException extends UniException {
    public EmptyFieldException(String message) {
        super(message);
    }
}
