package refscheduler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import refscheduler.domain.PersonCreate;
import refscheduler.domain.PersonGet;
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

    @RequestMapping(path = "/person/{personId}", method = RequestMethod.GET)
    public PersonGet getPerson(@PathVariable("personId") final Long personId) {

        //schedulingEngine.scheduleGames(Collections.singletonList(gameService.getGame(1L)), teamAffiliationService.getAllAffiliationsByTeam(1L));

        return personService.getPerson(personId);
    }

    @RequestMapping(path = "/persons", method = RequestMethod.GET)
    public List<PersonGet> getAllPersons() {
        return personService.getAll();
    }

    @RequestMapping(path = "/person", method = RequestMethod.POST)
    public Long createPerson(@RequestBody @Valid final PersonCreate personCreate) {
        return personService.createPerson(personCreate);
    }
}
