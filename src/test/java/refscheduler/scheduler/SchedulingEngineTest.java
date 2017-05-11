package refscheduler.scheduler;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import refscheduler.affiliation.Affiliation;
import refscheduler.game.Game;
import refscheduler.game.GameService;
import refscheduler.person.Person;
import refscheduler.team.Team;
import refscheduler.timeslot.Timeslot;

import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonMap;
import static refscheduler.affiliation.AffiliationType.PLAYER;
import static refscheduler.affiliation.builder.AffiliationBuilder.newAffiliation;
import static refscheduler.game.builder.GameBuilder.newGame;
import static refscheduler.person.Level.LEVEL_1;
import static refscheduler.person.builder.PersonBuilder.newPerson;
import static refscheduler.team.builder.TeamBuilder.newTeam;
import static refscheduler.timeslot.builder.TimeslotBuilder.newTimeslot;

public class SchedulingEngineTest {

    @InjectMocks
    private SchedulingEngine schedulingEngine;

    @Mock
    private GameService gameService;

    private Map<Timeslot, List<Game>> games;
    private List<Person> people;
    private List<Affiliation> affiliations;

    @Before
    public void setup() {
        // Teams
        Team teamA = newTeam().withName("Tornadoes").build();
        Team teamB = newTeam().withName("Velociraptors").build();
        Team teamC = newTeam().withName("Werewolves").build();
        Team teamD = newTeam().withName("Unspeakables").build();

        //Timeslot
        Timeslot timeslot = newTimeslot().withTime(DateTime.now()).build();

        // People
        Person johnDoe = newPerson().withFirstName("John").withLastName("Doe").withSnitch(false)
                .withHeadRefereeLevel(LEVEL_1).withAssistantRefereeLevel(LEVEL_1).withSnitchRefereeLevel(LEVEL_1).build();

        // Affiliations
        Affiliation affiliationJohnDoe =
                newAffiliation().withTeam(teamA).withPerson(johnDoe).withAffiliationType(PLAYER).build();

        // Games
        Game gameOne = newGame().withTeamA(teamA).withTeamB(teamB).withTimeslot(timeslot).withPitch(1L).build();
        Game gameTwo = newGame().withTeamA(teamC).withTeamB(teamD).withTimeslot(timeslot).withPitch(2L).build();

        games = singletonMap(timeslot, asList(gameOne, gameTwo));
        people = asList(johnDoe);
        affiliations = asList(affiliationJohnDoe);

    }

    @Test
    public void simpleSchedule() {
        schedulingEngine.scheduleGames(games, people, affiliations);
    }
}
