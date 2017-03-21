package refscheduler.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import refscheduler.person.PersonRepository;
import refscheduler.team.TeamRepository;
import refscheduler.timeslot.Timeslot;
import refscheduler.timeslot.TimeslotRepository;
import refscheduler.util.DozerMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * game scheduler.
 */
@Service("gameService")
public class GameService {

    @Autowired
    private DozerMapper mapper;

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private TimeslotRepository timeslotRepository;

    public Long save(final Game game) {
        final GameEntity entity = mapper.map(game, GameEntity.class);

        gameRepository.save(entity);

        return entity.getId();
    }

    public Game getGame(final Long gameId) {
        final GameEntity entity = gameRepository.findOne(gameId);

        return mapper.map(entity, Game.class);
    }

    public List<Game> getGames() {
        final List<GameEntity> entities = gameRepository.findAll();

        return mapper.map(entities, Game.class);
    }

    public void deleteGame(final Long gameId) {
        gameRepository.delete(gameId);
    }

    public Map<Timeslot, List<Game>> getAllGamesByTimeslot() {
        final List<GameEntity> entities = gameRepository.findAll();

        List<Game> games =  mapper.map(entities, Game.class);

        return games.stream().collect(Collectors.groupingBy(Game::getTimeslot, HashMap::new, Collectors.toList()));
    }
}
