package refscheduler.affiliation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The team affiliation controller.
 */
@RestController
@RequestMapping(produces = "application/json")
public class AffiliationController {

    @Autowired
    private AffiliationService affiliationService;

    @GetMapping(path = "/affiliation/{affiliationId}")
    public Affiliation getAffiliation(@PathVariable("affiliationId") final Long teamAffiliationId) {
        return affiliationService.getAffiliation(teamAffiliationId);
    }

    @GetMapping(path = "/affiliations/{teamId}")
    public List<Affiliation> getAffiliationsByTeam(@PathVariable("teamId") final Long teamId) {
        return affiliationService.getAllAffiliationsByTeam(teamId);
    }

    @GetMapping(path = "/affiliations")
    public List<Affiliation> getAllAffiliations() {
        return affiliationService.getAllAffiliations();
    }

    @PostMapping(path = "/affiliation")
    public Long createAffiliation(@RequestBody final Affiliation affiliation) {
        return affiliationService.save(affiliation);
    }

    @DeleteMapping(path = "/affiliation/{affiliationId}")
    public void deleteAffiliation(@PathVariable("affiliationId") final Long teamAffiliationId) {
        affiliationService.deleteAffiliation(teamAffiliationId);
    }
}
