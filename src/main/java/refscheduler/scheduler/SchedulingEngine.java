package refscheduler.scheduler;

import org.springframework.stereotype.Service;
import refscheduler.affiliation.Affiliation;
import refscheduler.game.Game;
import refscheduler.person.Person;
import refscheduler.timeslot.Timeslot;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.toList;

/**
 * The scheduler for scheduling games.
 */
@Service("schedulingEngine")
public class SchedulingEngine {

    public Map<Timeslot, List<Game>> scheduleGames(final Map<Timeslot, List<Game>> allGames,
                              final List<Person> persons,
                              final List<Affiliation> affiliations) {

        for (Timeslot timeslot : allGames.keySet()) {
            allGames.put(timeslot, scheduleTimeslot(allGames.get(timeslot), persons, affiliations));
        }

        return allGames;
    }

    public List<Game> scheduleTimeslot(List<Game> games, List<Person> people, List<Affiliation> affiliations) {
        List<Person> usedPeople = new ArrayList<>();

        for (Game game : games) {
            List<Person> unavailablePeople = affiliations.stream()
                    .filter(x -> game.getTeamA().equals(x.getTeam())
                            || game.getTeamB().equals(x.getTeam())
                            || usedPeople.contains(x.getPerson()))
                    .map(Affiliation::getPerson)
                    .collect(toList());

            List<Person> potentialPeople = people.stream()
                    .filter(x -> !unavailablePeople.contains(x))
                    .collect(toList());

            if (potentialPeople.size() >= 6) {
                game.setHeadReferee(potentialPeople.get(0));
                usedPeople.add(potentialPeople.get(0));
                game.setAssistantRefereeA(potentialPeople.get(1));
                usedPeople.add(potentialPeople.get(1));
                game.setAssistantRefereeB(potentialPeople.get(2));
                usedPeople.add(potentialPeople.get(2));
                game.setAssistantRefereeC(potentialPeople.get(3));
                usedPeople.add(potentialPeople.get(3));
                game.setSnitchReferee(potentialPeople.get(4));
                usedPeople.add(potentialPeople.get(4));
                game.setSnitch(potentialPeople.get(5));
                usedPeople.add(potentialPeople.get(5));
            }
        }

        return games;
    }

    public boolean checkTournamentSchedule(Map<Timeslot, List<Game>> gamesToCheck) {
        boolean scheduleOkay = true;

        for (Timeslot timeslot : gamesToCheck.keySet()) {
            List<Game> gamesInTimeslot = gamesToCheck.get(timeslot);

            scheduleOkay = scheduleOkay && checkTimeslotSchedule(gamesInTimeslot);
        }

        return scheduleOkay;
    }

    public boolean checkTimeslotSchedule(List<Game> games) {
        Set<Person> affiliatedOfficials = new HashSet<>();

        for (Game game : games) {
            if (!affiliatedOfficials.addAll(game.getGameOfficials())) {
                return false;
            }
        }

        return true;
    }
}
