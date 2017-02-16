package refscheduler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import refscheduler.domain.TeamAffiliationCreate;
import refscheduler.domain.TeamAffiliationGet;
import refscheduler.service.TeamAffiliationService;

import java.util.List;

/**
 * The team affiliation controller.
 */
@RestController
@RequestMapping(produces = "application/json")
public class TeamAffiliationController {

    @Autowired
    private TeamAffiliationService teamAffiliationService;

    @GetMapping(path = "/affiliation/{affiliationId}")
    public TeamAffiliationGet getTeamAffiliation(@PathVariable("affiliationId") final Long teamAffiliationId) {
        return teamAffiliationService.getTeamAffiliation(teamAffiliationId);
    }

    @GetMapping(path = "/affiliations/{teamId}")
    public List<TeamAffiliationGet> getTeamAffiliationsByTeam(@PathVariable("teamId") final Long teamId) {
        return teamAffiliationService.getAllAffiliationsByTeam(teamId);
    }

    @GetMapping(path = "/affiliations")
    public List<TeamAffiliationGet> getAllTeamAffiliations() {
        return teamAffiliationService.getAllAffiliations();
    }

    @PostMapping(path = "/affiliations")
    public Long createTeamAffiliation(@RequestBody final TeamAffiliationCreate affiliationCreate) {
        return teamAffiliationService.createTeamAffiliation(affiliationCreate);
    }
}
