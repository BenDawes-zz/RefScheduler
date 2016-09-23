package refscheduler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import refscheduler.domain.TeamCreate;
import refscheduler.domain.TeamGet;
import refscheduler.service.TeamService;

import javax.validation.Valid;

/**
 * Team controller.
 */
@RestController
@RequestMapping(produces = "application/json")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @RequestMapping(path = "/team/{teamId}", method = RequestMethod.GET)
    public TeamGet findTeam(@PathVariable("teamId") final Long teamId) {
        return teamService.findTeam(teamId);
    }

    @RequestMapping(value = "/team", method = RequestMethod.POST)
    public Long createTeam(@RequestBody @Valid final TeamCreate teamCreate) {
        return teamService.createTeam(teamCreate);
    }
}
