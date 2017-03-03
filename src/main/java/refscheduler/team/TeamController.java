package refscheduler.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Team controller.
 */
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping(path = "/team/{teamId}")
    public Team getTeam(@PathVariable("teamId") final Long teamId) {
        return teamService.getTeam(teamId);
    }

    @GetMapping(path = "/teams")
    public List<Team> getTeams() {
        return teamService.getTeams();
    }

    @PostMapping(path = "/team")
    public Long createTeam(@RequestBody @Valid final Team team) {
        return teamService.save(team);
    }
}
