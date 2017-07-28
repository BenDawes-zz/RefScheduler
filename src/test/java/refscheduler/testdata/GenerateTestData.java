package refscheduler.testdata;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import refscheduler.Main;
import refscheduler.affiliation.Affiliation;
import refscheduler.affiliation.AffiliationService;
import refscheduler.person.Person;
import refscheduler.person.PersonService;
import refscheduler.team.Team;
import refscheduler.team.TeamService;
import refscheduler.timeslot.Timeslot;
import refscheduler.timeslot.TimeslotService;

import java.util.List;

import static refscheduler.affiliation.builder.AffiliationBuilder.newAffiliation;
import static refscheduler.person.builder.PersonBuilder.newPerson;
import static refscheduler.team.builder.TeamBuilder.newTeam;
import static refscheduler.timeslot.builder.TimeslotBuilder.newTimeslot;

/**
 * Reads data from the CSV files and adds it to the database
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class)
public class GenerateTestData {

    private CsvUtils csvUtils = new CsvUtils();

    @Autowired
    private PersonService personService;
    @Autowired
    private TeamService teamService;
    @Autowired
    private AffiliationService affiliationService;
    @Autowired
    private TimeslotService timeslotService;

    private List<String[]> peopleLines;
    private List<String[]> teamLines;
    private List<String[]> affiliationLines;
    private List<String[]> timeslotLines;

    @Before
    public void readCsvFiles() {
        peopleLines = csvUtils.readPeopleLines();
        teamLines = csvUtils.readTeamLines();
        affiliationLines = csvUtils.readAffiliationLines();
        timeslotLines = csvUtils.readTimeslotLines();
    }

    @Ignore
    @Test
    public void generateTestData() {
        generatePeople();
        generateTeams();
        generateAffiliations();
        generateTimeslots();
    }

    private void generatePeople() {
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

    private void generateTeams() {
        for (String[] line : teamLines) {
            CsvUtils.TeamLine teamLine = new CsvUtils.TeamLine(line);

            Team team = newTeam()
                    .withName(teamLine.name)
                    .withLocation(teamLine.location)
                    .build();

            teamService.save(team);
        }
    }

    private void generateAffiliations() {
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

    private void generateTimeslots() {
        for (String[] line : timeslotLines) {
            CsvUtils.TimeslotLine timeslotLine = new CsvUtils.TimeslotLine(line);

            Timeslot timeslot = newTimeslot()
                    .withTime(timeslotLine.time)
                    .build();

            timeslotService.save(timeslot);
        }
    }
}
