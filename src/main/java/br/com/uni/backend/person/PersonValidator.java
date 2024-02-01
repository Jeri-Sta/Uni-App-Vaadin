package br.com.uni.backend.person;

import br.com.uni.backend.common.messages.GeneralMessages;
import br.com.uni.backend.common.validator.Validator;
import br.com.uni.backend.exception.UniException;
import br.com.uni.backend.exception.bundle.EmptyFieldException;
import br.com.uni.backend.person.model.Person;

public class PersonValidator implements Validator<Person> {

    @Override
    public void validateFields(Person entity) throws UniException {
        if(entity.getName() == null){
            throw new EmptyFieldException("Nome" + GeneralMessages.EMPTY_FIELD);
        } else if (entity.getPhone() == null) {
            throw new EmptyFieldException("Telefone" + GeneralMessages.EMPTY_FIELD);
        } else if (entity.getSex() == null) {
            throw new EmptyFieldException("Sexo" + GeneralMessages.EMPTY_FIELD);
        } else if (entity.getSmallGroupRole() == null) {
            throw new EmptyFieldException("Papel do PG" + GeneralMessages.EMPTY_FIELD);
        }
    }
}
