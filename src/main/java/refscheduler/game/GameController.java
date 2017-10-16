package refscheduler.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import refscheduler.affiliation.AffiliationService;
import refscheduler.person.PersonService;
import refscheduler.scheduler.SchedulingEngine;
import refscheduler.timeslot.Timeslot;
import refscheduler.util.csvdata.DataGenerator;

import java.util.List;
import java.util.Map;

/**
 * game controller.
 */
@RestController
@RequestMapping(path = "/game", produces = "application/json")
public class GameController {

    @Autowired
    private SchedulingEngine schedulingEngine;

    @Autowired
    private DataGenerator dataGenerator;

    @Autowired
    private GameService gameService;

    @Autowired
    private AffiliationService affiliationService;

    @Autowired
    private PersonService personService;

    @GetMapping(path = "/{gameId}")
    public Game getGame(@PathVariable("gameId") final Long gameId) {
        return gameService.getGame(gameId);
    }

    @PostMapping()
    public Long createGame(@RequestBody final Game game) {
        return gameService.save(game);
    }

    @GetMapping()
    public List<Game> getAllGames() {
        return gameService.getGames();
    }

    @DeleteMapping(path = "/{gameId}")
    public void deleteGame(@PathVariable("gameId") final Long gameId) {
        gameService.deleteGame(gameId);
    }

    @GetMapping(path = "/schedule")
    public void scheduleAllGames() {
        Map<Timeslot, List<Game>> scheduledGames = schedulingEngine.scheduleGames(gameService.getAllGamesByTimeslot(),
                personService.getAll(),
                affiliationService.getAllAffiliations());

        for (List<Game> games : scheduledGames.values()) {
            games.forEach(gameService::save);
        }
    }

    @GetMapping(path = "/dummy-data")
    public void createDummyData() {
        dataGenerator.generateDummyData();
    }
}
