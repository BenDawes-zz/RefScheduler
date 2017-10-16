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
import refscheduler.team.TeamService;
import refscheduler.timeslot.Timeslot;
import refscheduler.util.csvdata.DataGenerator;

import java.util.List;
import java.util.Map;

import static junit.framework.TestCase.assertTrue;

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
    private PersonService personService;

    @Autowired
    private AffiliationService affiliationService;

    @Autowired
    private DataGenerator generator;

    @Before
    public void setUp() {
        generator.generateDummyData();
    }

    @Test
    public void simpleSchedule() {
        Map<Timeslot, List<Game>> games = gameService.getAllGamesByTimeslot();
        List<Person> people = personService.getAll();
        List<Affiliation> affiliations = affiliationService.getAllAffiliations();

        schedulingEngine.scheduleGames(games, people, affiliations);

        games = gameService.getAllGamesByTimeslot();

        assertTrue(schedulingEngine.checkTournamentSchedule(games));
    }
}
