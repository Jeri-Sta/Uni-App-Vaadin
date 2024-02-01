package br.com.uni.backend.person;

import br.com.uni.backend.person.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    Collection<Person> findBySmallGroupId(Long smallGroupId);
}
