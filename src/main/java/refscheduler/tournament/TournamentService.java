package refscheduler.tournament;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import refscheduler.util.DozerMapper;

import java.util.List;

/**
 * Tournament Service
 */
@Service("tournamentService")
public class TournamentService {

    @Autowired
    private DozerMapper mapper;

    @Autowired
    private TournamentRepository tournamentRepository;

    public Long save(final Tournament tournament) {
        final TournamentEntity entity = mapper.map(tournament, TournamentEntity.class);

        tournamentRepository.save(entity);

        return entity.getId();
    }

    public Tournament getTournament(final Long tournamentId) {
        final TournamentEntity entity = tournamentRepository.findOne(tournamentId);

        return mapper.map(entity, Tournament.class);
    }

    public List<Tournament> getAllTournaments() {
        final List<TournamentEntity> entities = tournamentRepository.findAll();

        return mapper.map(entities, Tournament.class);
    }

    public void deleteTournament(final Long tournamentId) {
        tournamentRepository.delete(tournamentId);
    }
}
