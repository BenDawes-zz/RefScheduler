package refscheduler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import refscheduler.domain.Team;
import refscheduler.entity.TeamEntity;
import refscheduler.repository.TeamRepository;
import refscheduler.util.DozerMapper;

import java.util.List;

/**
 * Team service.
 */
@Service("teamService")
public class TeamService {

    @Autowired
    private DozerMapper mapper;

    @Autowired
    private TeamRepository teamRepository;

    public Team getTeam(final Long teamId) {
        final TeamEntity entity = teamRepository.findOne(teamId);

        return mapper.map(entity, Team.class);
    }

    public List<Team> getTeams() {
        final List<TeamEntity> entities = teamRepository.findAll();

        return mapper.map(entities, Team.class);
    }

    public Long save(final Team team) {
        final TeamEntity entity = mapper.map(team, TeamEntity.class);

        teamRepository.save(entity);

        return entity.getId();
    }
}
