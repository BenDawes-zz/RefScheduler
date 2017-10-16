package refscheduler.util.csvdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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

import java.util.List;

import static java.util.Arrays.asList;
import static refscheduler.affiliation.builder.AffiliationBuilder.newAffiliation;
import static refscheduler.game.builder.GameBuilder.newGame;
import static refscheduler.person.builder.PersonBuilder.newPerson;
import static refscheduler.team.builder.TeamBuilder.newTeam;
import static refscheduler.timeslot.builder.TimeslotBuilder.newTimeslot;

/**
 * Reads data from the CSV files and adds it to the database
 */
@Component
public class DataGenerator {

    private CsvUtils csvUtils = new CsvUtils();

    @Autowired
    private PersonService personService;

    @Autowired
    private TeamService teamService;

    @Autowired
    private AffiliationService affiliationService;

    @Autowired
    private TimeslotService timeslotService;

    @Autowired
    private GameService gameService;

    public void generateDummyData() {
        generatePeople(csvUtils.readPeopleLines());
        generateTimeslots(csvUtils.readTimeslotLines());
        generateTeams(csvUtils.readTeamLines());
        generateAffiliations(csvUtils.readAffiliationLines());
        generateGames(csvUtils.readGameLines());
    }

    public void generatePeople(List<String[]> peopleLines) {
        for (String[] line : peopleLines) {
            CsvUtils.PeopleLine peopleLine = new CsvUtils.PeopleLine(line);

            Person person = newPerson()
                    .withFirstName(peopleLine.firstName)
                    .withLastName(peopleLine.lastName)
                    .withEmailAddress(peopleLine.email)
                    .withHeadRefereeLevel(peopleLine.hrLevel)
                    .withAssistantRefereeLevel(peopleLine.arLevel)
                    .withSnitchRefereeLevel(peopleLine.srLevel)
                    .withSnitch(peopleLine.snitch)
                    .build();

            personService.save(person);
        }
    }

    public void generateTeams(List<String[]> teamLines) {
        for (String[] line : teamLines) {
            CsvUtils.TeamLine teamLine = new CsvUtils.TeamLine(line);

            Team team = newTeam()
                    .withName(teamLine.name)
                    .withLocation(teamLine.location)
                    .build();

            teamService.save(team);
        }
    }

    public void generateAffiliations(List<String[]> affiliationLines) {
        for (String[] line : affiliationLines) {
            CsvUtils.AffiliationLine affiliationLine = new CsvUtils.AffiliationLine(line);

            Affiliation affiliation = newAffiliation()
                    .withPerson(personService.getByName(affiliationLine.personName))
                    .withTeam(teamService.getByName(affiliationLine.teamName))
                    .withAffiliationType(affiliationLine.affiliationType)
                    .build();

            affiliationService.save(affiliation);
        }
    }

    public void generateTimeslots(List<String[]> timeslotLines) {
        for (String[] line : timeslotLines) {
            CsvUtils.TimeslotLine timeslotLine = new CsvUtils.TimeslotLine(line);

            Timeslot timeslot = newTimeslot()
                    .withTime(timeslotLine.time)
                    .build();

            timeslotService.save(timeslot);
        }
    }

    public void generateGames(List<String[]> gameLines) {
        for (String[] line : gameLines) {
            CsvUtils.GameLine gameLine = new CsvUtils.GameLine(line);

            Game game;

            if (line.length > 4) {
                List<Person> assistantReferees = asList(
                    personService.getByName(gameLine.assistantRefereeA),
                    personService.getByName(gameLine.assistantRefereeB),
                    personService.getByName(gameLine.assistantRefereeC),
                    personService.getByName(gameLine.assistantRefereeD)
                );

                game = newGame()
                        .withTimeslot(timeslotService.getTimeslotByTime(gameLine.time))
                        .withPitch(gameLine.pitch)
                        .withTeamA(teamService.getByName(gameLine.teamA))
                        .withTeamB(teamService.getByName(gameLine.teamB))
                        .withHeadReferee(personService.getByName(gameLine.headReferee))
                        .withAssistantReferees(assistantReferees)
                        .withSnitchReferee(personService.getByName(gameLine.snitchReferee))
                        .withSnitch(personService.getByName(gameLine.snitch))
                        .build();
            } else {
                game = newGame()
                        .withTimeslot(timeslotService.getTimeslotByTime(gameLine.time))
                        .withPitch(gameLine.pitch)
                        .withTeamA(teamService.getByName(gameLine.teamA))
                        .withTeamB(teamService.getByName(gameLine.teamB))
                        .build();
            }

            gameService.save(game);
        }
    }
}
