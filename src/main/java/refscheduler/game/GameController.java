package refscheduler.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import refscheduler.affiliation.AffiliationService;
import refscheduler.person.PersonService;
import refscheduler.scheduler.SchedulingEngine;

import java.util.List;

/**
 * game controller.
 */
@RestController
@RequestMapping(path = "/game", produces = "application/json")
public class GameController {

    @Autowired
    private SchedulingEngine schedulingEngine;

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
        schedulingEngine.scheduleGames(gameService.getAllGamesByTimeslot(),
                personService.getAll(),
                affiliationService.getAllAffiliations());
    }
}
