package br.com.uni.backend.exception.bundle;

import br.com.uni.backend.exception.UniException;

public class EntityNotFoundException extends UniException {
    public EntityNotFoundException(String message) {
        super(message);
    }
}
