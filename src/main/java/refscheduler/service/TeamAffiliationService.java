package refscheduler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import refscheduler.domain.TeamAffiliationCreate;
import refscheduler.domain.TeamAffiliationGet;
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

    public TeamAffiliationGet getTeamAffiliation(final Long affiliationId) {
        final TeamAffiliationEntity entity = teamAffiliationRepository.findOne(affiliationId);

        return mapper.map(entity, TeamAffiliationGet.class);
    }

    public List<TeamAffiliationGet> getAllAffiliationsByTeam(final Long teamId) {
        final TeamEntity teamEntity = teamRepository.findOne(teamId);

        final List<TeamAffiliationEntity> entities = teamAffiliationRepository.findByTeam(teamEntity);

        return mapper.map(entities, TeamAffiliationGet.class);
    }

    public List<TeamAffiliationGet> getAllAffiliations() {
        final List<TeamAffiliationEntity> entities = teamAffiliationRepository.findAll();

        return mapper.map(entities, TeamAffiliationGet.class);
    }

    public Long createTeamAffiliation(final TeamAffiliationCreate affiliationCreate) {
        final TeamAffiliationEntity entity = new TeamAffiliationEntity();

        entity.setTeam(teamRepository.findOne(affiliationCreate.getTeamId()));
        entity.setPerson(personRepository.findOne(affiliationCreate.getPersonId()));
        entity.setAffiliation(affiliationCreate.getAffiliation());

        teamAffiliationRepository.save(entity);

        return entity.getAffiliationId();
    }
}
