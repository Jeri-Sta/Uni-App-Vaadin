package br.com.uni.backend.person;

import br.com.uni.backend.common.messages.GeneralMessages;
import br.com.uni.backend.exception.UniException;
import br.com.uni.backend.exception.bundle.EntityNotFoundException;
import br.com.uni.backend.person.model.Person;
import br.com.uni.backend.person.model.PersonInput;
import br.com.uni.backend.smallgroup.SmallGroupRepository;
import br.com.uni.backend.smallgroup.model.SmallGroup;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonService {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private SmallGroupRepository smallGroupRepository;
    @Autowired
    private ModelMapper modelMapper;
    private PersonValidator personValidator;

    public Page<PersonInput> listAll(Pageable pageable) {
        return personRepository.findAll(pageable).map(p -> modelMapper.map(p, PersonInput.class));
    }

    public PersonInput listById(Long id) throws UniException {
        Optional<Person> optional = personRepository.findById(id);
        if(optional.isEmpty()){
            throw new EntityNotFoundException(GeneralMessages.PERSON_NOT_FIND);
        }
        return modelMapper.map(optional.get(), PersonInput.class);
    }

    public PersonInput createPerson(PersonInput dto) throws UniException {
        Person person = modelMapper.map(dto, Person.class);
        if(dto.getSmallGroup() != null) {
            person.setSmallGroup(this.findSmallGroup(dto.getSmallGroup().getId()));
        }
        personValidator.validateFields(person);
        personRepository.save(person);
        return modelMapper.map(person, PersonInput.class);
    }

    public PersonInput updatePerson(PersonInput dto) throws UniException {
        Person person = modelMapper.map(dto, Person.class);
        if(dto.getSmallGroup() != null) {
            person.setSmallGroup(this.findSmallGroup(dto.getSmallGroup().getId()));
        }
        if(personRepository.findById(person.getId()).isEmpty()){
            throw new EntityNotFoundException("Pessoa" + GeneralMessages.ENTITY_NOT_FOUND);
        }
        personValidator.validateFields(person);
        personRepository.save(person);
        return modelMapper.map(person, PersonInput.class);

    }

    private SmallGroup findSmallGroup(Long id) throws UniException {
        Optional<SmallGroup> result = smallGroupRepository.findById(id);
        if(result.isEmpty()) {
            throw new EntityNotFoundException(GeneralMessages.SMALL_GROUP_NOT_FOUND);
        }
        return result.get();
    }
}
