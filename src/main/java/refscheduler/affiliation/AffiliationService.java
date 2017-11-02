package refscheduler.affiliation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Service;
import refscheduler.team.TeamEntity;
import refscheduler.person.PersonRepository;
import refscheduler.team.TeamRepository;
import refscheduler.tournament.Tournament;
import refscheduler.tournament.TournamentEntity;
import refscheduler.tournament.TournamentRepository;
import refscheduler.util.DozerMapper;

import java.util.List;

/**
 * The team affiliation scheduler.
 */
@Service("teamAffiliationService")
public class AffiliationService {

    @Autowired
    private DozerMapper mapper;

    @Autowired
    private AffiliationRepository affiliationRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private TournamentRepository tournamentRepository;

    public Affiliation getAffiliation(final Long affiliationId) {
        final AffiliationEntity entity = affiliationRepository.findOne(affiliationId);

        return mapper.map(entity, Affiliation.class);
    }

    public List<Affiliation> getAllAffiliationsByTeam(final Long teamId) {
        final TeamEntity teamEntity = teamRepository.findOne(teamId);

        final List<AffiliationEntity> entities = affiliationRepository.findByTeam(teamEntity);

        return mapper.map(entities, Affiliation.class);
    }

    public List<Affiliation> getAllAffiliations() {
        final List<AffiliationEntity> entities = affiliationRepository.findAll();

        return mapper.map(entities, Affiliation.class);
    }

    public Long save(final Affiliation affiliation) {
        final AffiliationEntity entity = mapper.map(affiliation, AffiliationEntity.class);
        final TournamentEntity tournament = tournamentRepository.findOne(affiliation.getTournamentId());
        entity.setTournament(tournament);

        affiliationRepository.save(entity);

        return entity.getId();
    }

    public void deleteAffiliation(final Long affiliationId) {
        affiliationRepository.delete(affiliationId);
    }
}
