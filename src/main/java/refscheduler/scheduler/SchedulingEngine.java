package refscheduler.scheduler;

import org.springframework.stereotype.Service;
import refscheduler.affiliation.Affiliation;
import refscheduler.game.Game;
import refscheduler.person.Level;
import refscheduler.person.Person;
import refscheduler.timeslot.Timeslot;
import refscheduler.util.HungarianAlgorithm;

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

    private static final double HIGH_COST = 1000;
    private static final int MAX_ARS_PER_GAME = 4;

    public Map<Timeslot, List<Game>> scheduleGames(final Map<Timeslot, List<Game>> allGames,
                              final List<Person> persons,
                              final List<Affiliation> affiliations) {

        for (Timeslot timeslot : allGames.keySet()) {
            allGames.put(timeslot, scheduleTimeslot(allGames.get(timeslot), persons, affiliations));
        }

        return allGames;
    }

    public List<Game> scheduleTimeslot(List<Game> games, List<Person> people, List<Affiliation> affiliations) {
        // Create cost matrix from games and people
        double[][] costMatrix = createCostMatrix(games, people, affiliations, 3);

        // Solve cost matrix
        HungarianAlgorithm hungarianAlgorithm = new HungarianAlgorithm(costMatrix);
        int[] assignments = hungarianAlgorithm.execute();

        // Convert back to assignments
        return parseAssignments(assignments, games, people, 3);
    }

    private double[][] createCostMatrix(final List<Game> games, final List<Person> people, final List<Affiliation> affiliations, final int arsPerGame) {
        int numberOfOfficialsPerGame = (3 + arsPerGame);
        int numberOfOfficialSlotsRequired = games.size() * numberOfOfficialsPerGame;
        int numberOfOfficialsAvailable = people.size();
        
        if (numberOfOfficialsAvailable < numberOfOfficialSlotsRequired) {
            throw new IllegalArgumentException("Not enough referees to schedule");
        }
        
        double[][] costMatrix = new double[numberOfOfficialsAvailable][numberOfOfficialsAvailable];

        // i-axis is officials available
        for (int i = 0; i < numberOfOfficialsAvailable; i++) {
            Person currentOfficial = people.get(i);
            List<Affiliation> currentAffiliations = affiliations
                    .stream()
                    .filter(affiliation -> affiliation.getPerson().equals(currentOfficial))
                    .collect(toList());

            // jk-axis is games to assign
            for (int j = 0; j < games.size(); j++) {
                Game currentGame = games.get(j);
                List<Affiliation> affiliationsForCurrentGame = currentAffiliations
                        .stream()
                        .filter(affiliation -> currentGame.involvesTeam(affiliation.getTeam()))
                        .collect(toList());

                for (int k = 0; k < numberOfOfficialsPerGame; k++) {
                    double cost;

                    if (affiliationsForCurrentGame.size() > 0) {
                        cost = HIGH_COST;
                    } else {
                        if (k == 0) {
                            cost = currentOfficial.getHeadRefereeLevel().level();
                        } else if (k <= arsPerGame) {
                            cost = currentOfficial.getAssistantRefereeLevel().level();
                        } else if (k == numberOfOfficialsPerGame - 2) {
                            cost = currentOfficial.getSnitchRefereeLevel().level();
                        } else {
                            cost = currentOfficial.getSnitchLevel().level() == Level.LEVEL_5.level()
                                ? HIGH_COST
                                : currentOfficial.getSnitchLevel().level();
                        }
                    }

                    costMatrix[i][(j * numberOfOfficialsPerGame) + k] = cost;
                }
            }
        }
        
        return costMatrix;
    }

    private List<Game> parseAssignments(final int[] assignments, final List<Game> games, final List<Person> people, final int arsPerGame) {
        int numberOfOfficialsPerGame = arsPerGame + 3;
        int numberOfOfficialsRequired = numberOfOfficialsPerGame * games.size();
        for (int i = 0; i < assignments.length; i++) {
            int assignedOfficialSlot = assignments[i];

            if (assignedOfficialSlot >= numberOfOfficialsRequired) {
                continue;
            }

            Person currentPerson = people.get(i);
            int gameIndex = assignedOfficialSlot / numberOfOfficialsPerGame;
            int exactOfficialSlot = assignedOfficialSlot - (gameIndex * numberOfOfficialsPerGame);
            Game game = games.get(gameIndex);

            if (exactOfficialSlot == 0) {
                game.setHeadReferee(currentPerson);
            } else if (exactOfficialSlot > 0 && exactOfficialSlot <= arsPerGame) {
                game.addAssistantReferee(currentPerson);
            } else if (exactOfficialSlot == numberOfOfficialsPerGame - 2) {
                game.setSnitchReferee(currentPerson);
            } else {
                game.setSnitch(currentPerson);
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
