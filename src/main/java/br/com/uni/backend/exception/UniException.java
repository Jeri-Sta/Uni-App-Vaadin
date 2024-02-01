package br.com.uni.backend.exception;

public class UniException extends Exception {

    private static final long serialVersionUID = 1L;

    public UniException(String message){
        super(message);
    }
}
