package refscheduler.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import refscheduler.affiliation.Affiliation;
import refscheduler.game.Game;
import refscheduler.game.GameService;
import refscheduler.person.Person;
import refscheduler.timeslot.Timeslot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

/**
 * The scheduler for scheduling games.
 */
@Service("schedulingEngine")
public class SchedulingEngine {

    @Autowired
    private GameService gameService;

    public void scheduleGames(final Map<Timeslot, List<Game>> allGames,
                              final List<Person> persons,
                              final List<Affiliation> affiliations) {
        for (List<Game> timeslotGames : allGames.values()) {
            List<Person> usedPeople = new ArrayList<>();

            for (Game game : timeslotGames) {
                List<Person> unavailablePeople = affiliations.stream()
                        .filter(x -> game.getTeamA().equals(x.getTeam())
                        || game.getTeamB().equals(x.getTeam())
                        || usedPeople.contains(x.getPerson()))
                        .map(Affiliation::getPerson)
                        .collect(toList());

                List<Person> potentialPeople = persons.stream()
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

                    gameService.save(game);
                }
            }
        }
    }
}
