package refscheduler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import refscheduler.domain.TeamCreate;
import refscheduler.domain.TeamGet;
import refscheduler.entity.TeamEntity;
import refscheduler.repository.TeamRepository;
import refscheduler.util.DozerMapper;

import java.util.ArrayList;
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

    public TeamGet getTeam(final Long teamId) {
        final TeamEntity entity = teamRepository.findOne(teamId);

        return mapper.map(entity, TeamGet.class);
    }

    public List<TeamGet> getTeams() {
        final Iterable<TeamEntity> entities = teamRepository.findAll();

        return mapper.map(entities, new ArrayList<TeamGet>().getClass());
    }

    public Long createTeam(final TeamCreate teamCreate) {
        final TeamEntity entity = new TeamEntity();

        entity.setName(teamCreate.getName());
        entity.setLocation(teamCreate.getLocation());

        teamRepository.save(entity);

        return entity.getTeamId();
    }
}
