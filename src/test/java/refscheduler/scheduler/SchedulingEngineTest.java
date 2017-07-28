package refscheduler.scheduler;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import refscheduler.Main;
import refscheduler.affiliation.Affiliation;
import refscheduler.affiliation.AffiliationService;
import refscheduler.game.Game;
import refscheduler.game.GameService;
import refscheduler.person.Person;
import refscheduler.person.PersonService;
import refscheduler.team.Team;
import refscheduler.team.TeamService;
import refscheduler.timeslot.Timeslot;
import refscheduler.timeslot.TimeslotService;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonMap;
import static refscheduler.game.builder.GameBuilder.newGame;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class)
public class SchedulingEngineTest {

    @Autowired
    private SchedulingEngine schedulingEngine;

    @Autowired
    private GameService gameService;

    @Autowired
    private TeamService teamService;

    @Autowired
    private TimeslotService timeslotService;

    @Autowired
    private PersonService personService;

    @Autowired
    private AffiliationService affiliationService;

    private Map<Timeslot, List<Game>> games;
    private List<Person> people;
    private List<Affiliation> affiliations;
    private List<Timeslot> timeslots;

    @Before
    public void setup() {
        List<Team> teams = teamService.getTeams();
        timeslots = timeslotService.getAllTimeslots();
        people = personService.getAll();
        affiliations = affiliationService.getAllAffiliations();

        // Games
        Game gameOne = newGame().withTeamA(teams.get(0)).withTeamB(teams.get(1)).withTimeslot(timeslots.get(0)).withPitch(1L).build();
        Game gameTwo = newGame().withTeamA(teams.get(2)).withTeamB(teams.get(3)).withTimeslot(timeslots.get(0)).withPitch(2L).build();

        games = singletonMap(timeslots.get(0), asList(gameOne, gameTwo));
    }

    @Test
    public void simpleSchedule() {
        schedulingEngine.scheduleGames(games, people, affiliations);

        List<Game> games = gameService.getGames();

        for (Timeslot timeslot : timeslots) {
            Set<Person> scheduledOfficials = new HashSet<>();

            games.stream()
                .filter(game -> timeslot.equals(game.getTimeslot()))
                .map(game -> scheduledOfficials.addAll(game.getGameOfficials()));

            System.out.println(scheduledOfficials);
        }
    }
}
