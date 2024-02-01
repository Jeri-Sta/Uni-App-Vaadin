package br.com.uni.backend.smallgroup;

import br.com.uni.backend.common.messages.GeneralMessages;
import br.com.uni.backend.common.validator.Validator;
import br.com.uni.backend.exception.UniException;
import br.com.uni.backend.exception.bundle.EmptyFieldException;
import br.com.uni.backend.smallgroup.model.SmallGroup;

public class SmallGroupValidator implements Validator<SmallGroup> {

    @Override
    public void validateFields(SmallGroup entity) throws UniException {
        if(entity.getName() == null){
            throw new EmptyFieldException("Nome" + GeneralMessages.EMPTY_FIELD);
        } else if (entity.getWeekDay() == null) {
            throw new EmptyFieldException("Dia da semana" + GeneralMessages.EMPTY_FIELD);
        } else if (entity.getSex() == null) {
            throw new EmptyFieldException("Sexo" + GeneralMessages.EMPTY_FIELD);
        } else if (entity.getTime() == null) {
            throw new EmptyFieldException("Horário" + GeneralMessages.EMPTY_FIELD);
        }
    }
}
