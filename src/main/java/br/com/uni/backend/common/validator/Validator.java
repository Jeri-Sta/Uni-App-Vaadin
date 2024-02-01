package br.com.uni.backend.common.validator;

import br.com.uni.backend.exception.UniException;

public interface Validator <T> {

    void validateFields(T entity) throws UniException;
}
