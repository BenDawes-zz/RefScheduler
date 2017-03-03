package refscheduler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import refscheduler.domain.Person;
import refscheduler.service.PersonService;

import javax.validation.Valid;
import java.util.List;

/**
 * Person controller.
 */
@RestController
@RequestMapping(produces = "application/json")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping(path = "/person/{personId}")
    public Person getPerson(@PathVariable("personId") final Long personId) {
        return personService.getPerson(personId);
    }

    @PutMapping(path = "/person/{personId}")
    public Long updatePerson(@PathVariable("personId") final Long personId,
                             @RequestBody final Person person) {
        return personService.save(person);
    }

    @GetMapping(path = "/persons")
    public List<Person> getAllPersons() {
        return personService.getAll();
    }

    @PostMapping(path = "/person")
    public Long createPerson(@RequestBody @Valid final Person person) {
        return personService.save(person);
    }

    @DeleteMapping(path = "/person/{personId}")
    public void deletePerson(@PathVariable("personId") final Long personId) {
        personService.deletePerson(personId);
    }
}
