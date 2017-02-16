package refscheduler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import refscheduler.domain.PersonCreate;
import refscheduler.domain.PersonGet;
import refscheduler.domain.PersonUpdate;
import refscheduler.service.GameService;
import refscheduler.service.PersonService;
import refscheduler.service.SchedulingEngine;
import refscheduler.service.TeamAffiliationService;

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

    @Autowired
    private TeamAffiliationService teamAffiliationService;

    @Autowired
    private GameService gameService;

    @Autowired
    private SchedulingEngine schedulingEngine;

    @GetMapping(path = "/person/{personId}")
    public PersonGet getPerson(@PathVariable("personId") final Long personId) {
        return personService.getPerson(personId);
    }

    @PutMapping(path = "/person/{personId}")
    public Long updatePerson(@PathVariable("personId") final Long personId,
                                  final PersonUpdate personUpdate) {
        return personService.updatePerson(personUpdate);
    }

    @GetMapping(path = "/persons")
    public List<PersonGet> getAllPersons() {
        return personService.getAll();
    }

    @PostMapping(path = "/person")
    public Long createPerson(@RequestBody @Valid final PersonCreate personCreate) {
        return personService.createPerson(personCreate);
    }

    @DeleteMapping(path = "/person/{personId}")
    public void deletePerson(@PathVariable("personId") final Long personId) {
        personService.deletePerson(personId);
    }
}
