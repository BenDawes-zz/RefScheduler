package refscheduler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import refscheduler.domain.PersonCreate;
import refscheduler.domain.PersonGet;
import refscheduler.service.PersonService;

import javax.validation.Valid;

/**
 * Person controller.
 */
@RestController
@RequestMapping(produces = "application/json")
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping(path = "/person/{personId}", method = RequestMethod.GET)
    public PersonGet getPerson(@PathVariable("personId") final Long personId) {
        return personService.getPerson(personId);
    }

    @RequestMapping(path = "/person", method = RequestMethod.POST)
    public Long createPerson(@RequestBody @Valid final PersonCreate personCreate) {
        return personService.createPerson(personCreate);
    }
}
