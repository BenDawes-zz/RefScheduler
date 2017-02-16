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

    @GetMapping(path = "/game/{gameId}")
    public GameGet getGame(@PathVariable("gameId") final Long gameId) {
        return gameService.getGame(gameId);
    }

    @PostMapping(path = "/game")
    public Long createGame(@RequestBody @Valid final GameCreate gameCreate) {
        return gameService.createGame(gameCreate);
    }

    @GetMapping(path = "/games")
    public List<GameGet> getAllGames() {
        return gameService.getGames();
    }
}
