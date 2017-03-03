package refscheduler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import refscheduler.domain.Person;
import refscheduler.entity.PersonEntity;
import refscheduler.repository.PersonRepository;
import refscheduler.util.DozerMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Person service.
 */
@Service("personService")
public class PersonService {

    @Autowired
    private DozerMapper mapper;

    @Autowired
    private PersonRepository personRepository;

    public Person getPerson(final Long personId) {
        final PersonEntity entity = personRepository.findOne(personId);

        return mapper.map(entity, Person.class);
    }

    public List<Person> getAll() {
        final Iterable<PersonEntity> entities = personRepository.findAll();
        final List<Person> persons = new ArrayList<>();

        for (PersonEntity entity : entities) {
            persons.add(mapper.map(entity, Person.class));
        }
        return persons;
    }

    public Long save(final Person person) {
        final PersonEntity personEntity = mapper.map(person, PersonEntity.class);

        personRepository.save(personEntity);

        return personEntity.getId();
    }

    @Transactional
    public void deletePerson(final Long personId) {
        personRepository.delete(personId);
    }
}
