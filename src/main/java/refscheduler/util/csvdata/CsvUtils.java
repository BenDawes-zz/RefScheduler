package refscheduler.util.csvdata;

import org.joda.time.DateTime;
import refscheduler.affiliation.AffiliationType;
import refscheduler.person.Level;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Definitions for the CSV lines etc
 */
public class CsvUtils {

    public static class PeopleLine {

        public String firstName;
        public String lastName;
        public String email;
        public Level hrLevel;
        public Level arLevel;
        public Level srLevel;
        public Level snitch;

        public PeopleLine(String[] input) {
            int line = 0;

            firstName = input[line++];
            lastName = input[line++];
            email = input[line++];
            hrLevel = Level.valueOf(input[line++]);
            arLevel = Level.valueOf(input[line++]);
            srLevel = Level.valueOf(input[line++]);
            snitch = Level.valueOf(input[line]);
        }
    }

    public static class TeamLine {
        public String name;
        public String location;

        public TeamLine(String[] input) {
            int line = 0;

            name = input[line++];
            location = input[line];
        }
    }

    public static class AffiliationLine {
        public String personName;
        public String teamName;
        public AffiliationType affiliationType;

        public AffiliationLine(String[] input) {
            int line = 0;

            personName = input[line++];
            teamName = input[line++];
            affiliationType = AffiliationType.valueOf(input[line]);
        }
    }

    public static class TimeslotLine {
        public DateTime time;

        public TimeslotLine(String[] input) {
            int line = 0;

            time = DateTime.parse(input[line]);
        }
    }

    public static class GameLine {
        public DateTime time;
        public Long pitch;
        public String teamA;
        public String teamB;
        public String headReferee;
        public String assistantRefereeA;
        public String assistantRefereeB;
        public String assistantRefereeC;
        public String assistantRefereeD;
        public String snitchReferee;
        public String snitch;

        public GameLine(String[] input) {
            int line = 0;

            time = DateTime.parse(input[line++]);
            pitch = Long.parseLong(input[line++]);
            teamA = input[line++];
            teamB = input[line++];
            if (input.length > 4) {
                headReferee = input[line++];
                assistantRefereeA = input[line++];
                assistantRefereeB = input[line++];
                assistantRefereeC = input[line++];
                assistantRefereeD = input[line++];
                snitchReferee = input[line++];
                snitch = input[line];
            }
        }
    }

    public List<String[]> readPeopleLines() {
        return readCsvFileFromClasspath("data/people.csv");
    }

    public List<String[]> readTeamLines() {
        return readCsvFileFromClasspath("data/teams.csv");
    }

    public List<String[]> readAffiliationLines() {
        return readCsvFileFromClasspath("data/affiliations.csv");
    }

    public List<String[]> readTimeslotLines() {
        return readCsvFileFromClasspath("data/timeslots.csv");
    }

    public List<String[]> readGameLines() {
        return readCsvFileFromClasspath("data/games.csv");
    }

    private List<String[]> readCsvFileFromClasspath(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());
        List<String[]> lines = new ArrayList<>();

        try(Scanner scanner = new Scanner(file)) {
            // Skip header line
            scanner.nextLine();

            while(scanner.hasNextLine()) {
                lines.add(scanner.nextLine().split(","));
            }

            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }
}
