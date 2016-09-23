package refscheduler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import refscheduler.util.DozerMapper;
import refscheduler.domain.TeamCreate;
import refscheduler.domain.TeamGet;
import refscheduler.entity.TeamEntity;
import refscheduler.repository.TeamRepository;

/**
 * Team service.
 */
@Service("teamService")
public class TeamService {

    @Autowired
    private DozerMapper mapper;

    @Autowired
    private TeamRepository teamRepository;

    public TeamGet findTeam(final Long teamId) {
        final TeamEntity entity = teamRepository.findOne(teamId);

        return mapper.map(entity, TeamGet.class);
    }

    public Long createTeam(final TeamCreate teamCreate) {
        final TeamEntity entity = new TeamEntity();

        entity.setName(teamCreate.getName());
        entity.setLocation(teamCreate.getLocation());

        teamRepository.save(entity);

        return entity.getTeamId();
    }
}
