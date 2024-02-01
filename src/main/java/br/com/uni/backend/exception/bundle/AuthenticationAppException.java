package br.com.uni.backend.exception.bundle;

import br.com.uni.backend.exception.UniException;

public class AuthenticationAppException extends UniException {

    public AuthenticationAppException(String message) {
        super(message);
    }
}
