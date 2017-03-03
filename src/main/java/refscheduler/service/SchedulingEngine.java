package refscheduler.service;

import org.springframework.stereotype.Service;
import refscheduler.domain.Game;
import refscheduler.domain.Person;
import refscheduler.domain.TeamAffiliation;
import refscheduler.domain.Timeslot;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The service for scheduling games.
 */
@Service("schedulingEngine")
public class SchedulingEngine {

    private static final int NUMBER_OF_ARS = 3;

    public List<Timeslot> scheduleGames(final List<Timeslot> timeslots, final List<TeamAffiliation> affiliations) {

        for (Timeslot timeslot : timeslots) {
            List<Person> usedPeople = new ArrayList<>();

            for (Game game : timeslot.getGames()) {
                List<Person> unaffiliatedPeople = affiliations.stream()
                        .filter(affiliation -> !affiliation.getTeam().equals(game.getTeamA())
                                && !affiliation.getTeam().equals(game.getTeamB()))
                        .sorted()
                        .map(TeamAffiliation::getPerson)
                        .filter(personGet -> !usedPeople.contains(personGet))
                        .collect(Collectors.toList());

                if (unaffiliatedPeople.size() >= 3 + NUMBER_OF_ARS) {
                    game.setHeadReferee(unaffiliatedPeople.get(0));
                    game.setAssistantRefereeA(unaffiliatedPeople.get(1));
                    game.setAssistantRefereeB(unaffiliatedPeople.get(2));
                    game.setAssistantRefereeC(unaffiliatedPeople.get(3));
                    game.setSnitchReferee(unaffiliatedPeople.get(4));
                    game.setSnitch(unaffiliatedPeople.get(5));
                    usedPeople.add(unaffiliatedPeople.get(0));
                    usedPeople.add(unaffiliatedPeople.get(1));
                    usedPeople.add(unaffiliatedPeople.get(2));
                    usedPeople.add(unaffiliatedPeople.get(3));
                    usedPeople.add(unaffiliatedPeople.get(4));
                    usedPeople.add(unaffiliatedPeople.get(5));
                }
            }
        }

        return timeslots;
    }
}
