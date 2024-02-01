package br.com.uni.backend.user;

import br.com.uni.backend.common.messages.GeneralMessages;
import br.com.uni.backend.common.validator.Validator;
import br.com.uni.backend.exception.UniException;
import br.com.uni.backend.exception.bundle.EmptyFieldException;
import br.com.uni.backend.user.model.User;

public class UserValidator implements Validator<User> {

    @Override
    public void validateFields(User entity) throws UniException {
        if(entity.getPerson() == null) {
            throw new EmptyFieldException("Pessoa" + GeneralMessages.EMPTY_FIELD);
        } else if (entity.getEmail() == null) {
            throw new EmptyFieldException("Email" + GeneralMessages.EMPTY_FIELD);
        } else if (entity.getPassword() == null) {
            throw new EmptyFieldException("Senha" + GeneralMessages.EMPTY_FIELD);
        } else if (entity.getRole() == null) {
            throw new EmptyFieldException("Papel" + GeneralMessages.EMPTY_FIELD);
        }
    }
}
