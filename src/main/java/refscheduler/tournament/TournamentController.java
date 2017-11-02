package refscheduler.tournament;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Tournament controller
 */
@RestController
@RequestMapping(produces = "application/json")
public class TournamentController {

    @Autowired
    private TournamentService tournamentService;

    @GetMapping(path = "/tournament/{tournamentId}")
    public Tournament getTournament(@PathVariable("tournamentId") final Long tournamentId) {
        return tournamentService.getTournament(tournamentId);
    }

    @GetMapping(path = "/tournaments")
    public List<Tournament> getAllTournaments() {
        return tournamentService.getAllTournaments();
    }

    @PostMapping(path = "/tournament")
    public Long createTournament(@RequestBody @Valid final Tournament tournament) {
        return tournamentService.save(tournament);
    }

    @DeleteMapping(path = "/tournament/{tournamentId}")
    public void deleteTournament(@PathVariable("tournamentId") final Long tournamentId) {
        tournamentService.deleteTournament(tournamentId);
    }
}
