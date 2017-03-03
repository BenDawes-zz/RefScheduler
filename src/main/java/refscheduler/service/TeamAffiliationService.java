package refscheduler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import refscheduler.domain.TeamAffiliation;
import refscheduler.entity.TeamAffiliationEntity;
import refscheduler.entity.TeamEntity;
import refscheduler.repository.PersonRepository;
import refscheduler.repository.TeamAffiliationRepository;
import refscheduler.repository.TeamRepository;
import refscheduler.util.DozerMapper;

import java.util.List;

/**
 * The team affiliation service.
 */
@Service("teamAffiliationService")
public class TeamAffiliationService {

    @Autowired
    private DozerMapper mapper;

    @Autowired
    private TeamAffiliationRepository teamAffiliationRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private TeamRepository teamRepository;

    public TeamAffiliation getTeamAffiliation(final Long affiliationId) {
        final TeamAffiliationEntity entity = teamAffiliationRepository.findOne(affiliationId);

        return mapper.map(entity, TeamAffiliation.class);
    }

    public List<TeamAffiliation> getAllAffiliationsByTeam(final Long teamId) {
        final TeamEntity teamEntity = teamRepository.findOne(teamId);

        final List<TeamAffiliationEntity> entities = teamAffiliationRepository.findByTeam(teamEntity);

        return mapper.map(entities, TeamAffiliation.class);
    }

    public List<TeamAffiliation> getAllAffiliations() {
        final List<TeamAffiliationEntity> entities = teamAffiliationRepository.findAll();

        return mapper.map(entities, TeamAffiliation.class);
    }

    public Long save(final TeamAffiliation affiliation) {
        final TeamAffiliationEntity entity = mapper.map(affiliation, TeamAffiliationEntity.class);

        teamAffiliationRepository.save(entity);

        return entity.getId();
    }
}
