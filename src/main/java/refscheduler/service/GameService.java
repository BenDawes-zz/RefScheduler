package refscheduler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import refscheduler.domain.Game;
import refscheduler.entity.GameEntity;
import refscheduler.repository.GameRepository;
import refscheduler.repository.PersonRepository;
import refscheduler.repository.TeamRepository;
import refscheduler.repository.TimeslotRepository;
import refscheduler.util.DozerMapper;

import java.util.List;

/**
 * Game service.
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
}
