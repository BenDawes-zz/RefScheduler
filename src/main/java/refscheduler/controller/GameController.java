package refscheduler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import refscheduler.domain.GameCreate;
import refscheduler.domain.GameGet;
import refscheduler.service.GameService;

import javax.validation.Valid;
import java.util.List;

/**
 * Game controller.
 */
@RestController
@RequestMapping(produces = "application/json")
public class GameController {

    @Autowired
    private GameService gameService;

    @RequestMapping(path = "/game/{gameId}", method = RequestMethod.GET)
    public GameGet getGame(@PathVariable("gameId") final Long gameId) {
        return gameService.getGame(gameId);
    }

    @RequestMapping(path = "/game", method = RequestMethod.POST)
    public Long createGame(@RequestBody @Valid final GameCreate gameCreate) {
        return gameService.createGame(gameCreate);
    }

    @RequestMapping(path = "/games", method = RequestMethod.GET)
    public List<GameGet> getAllGames() {
        return gameService.getGames();
    }
}
