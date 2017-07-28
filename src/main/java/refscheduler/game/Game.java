package refscheduler.game;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import refscheduler.person.Person;
import refscheduler.team.Team;
import refscheduler.timeslot.Timeslot;

import java.util.Arrays;
import java.util.List;

/**
 * game GET DTO.
 */
public class Game {

    private Long id;

    private Timeslot timeslot;

    private Team teamA;

    private Team teamB;

    private Person headReferee;

    private Person assistantRefereeA;

    private Person assistantRefereeB;

    private Person assistantRefereeC;

    private Person assistantRefereeD;

    private Person snitchReferee;

    private Person snitch;

    private Long pitch;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timeslot getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(final Timeslot timeslot) {
        this.timeslot = timeslot;
    }

    public Team getTeamA() {
        return teamA;
    }

    public void setTeamA(Team teamA) {
        this.teamA = teamA;
    }

    public Team getTeamB() {
        return teamB;
    }

    public void setTeamB(Team teamB) {
        this.teamB = teamB;
    }

    public Person getHeadReferee() {
        return headReferee;
    }

    public void setHeadReferee(Person headReferee) {
        this.headReferee = headReferee;
    }

    public Person getAssistantRefereeA() {
        return assistantRefereeA;
    }

    public void setAssistantRefereeA(Person assistantRefereeA) {
        this.assistantRefereeA = assistantRefereeA;
    }

    public Person getAssistantRefereeB() {
        return assistantRefereeB;
    }

    public void setAssistantRefereeB(Person assistantRefereeB) {
        this.assistantRefereeB = assistantRefereeB;
    }

    public Person getAssistantRefereeC() {
        return assistantRefereeC;
    }

    public void setAssistantRefereeC(Person assistantRefereeC) {
        this.assistantRefereeC = assistantRefereeC;
    }

    public Person getAssistantRefereeD() {
        return assistantRefereeD;
    }

    public void setAssistantRefereeD(Person assistantRefereeD) {
        this.assistantRefereeD = assistantRefereeD;
    }

    public Person getSnitchReferee() {
        return snitchReferee;
    }

    public void setSnitchReferee(Person snitchReferee) {
        this.snitchReferee = snitchReferee;
    }

    public Person getSnitch() {
        return snitch;
    }

    public void setSnitch(Person snitch) {
        this.snitch = snitch;
    }

    public Long getPitch() {
        return pitch;
    }

    public void setPitch(Long pitch) {
        this.pitch = pitch;
    }

    public List<Person> getGameOfficials() {
        return Arrays.asList(
                headReferee,
                assistantRefereeA,
                assistantRefereeB,
                assistantRefereeC,
                assistantRefereeD,
                snitchReferee,
                snitch
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Game game = (Game) o;

        return new EqualsBuilder()
                .append(id, game.id)
                .append(timeslot, game.timeslot)
                .append(teamA, game.teamA)
                .append(teamB, game.teamB)
                .append(headReferee, game.headReferee)
                .append(assistantRefereeA, game.assistantRefereeA)
                .append(assistantRefereeB, game.assistantRefereeB)
                .append(assistantRefereeC, game.assistantRefereeC)
                .append(assistantRefereeD, game.assistantRefereeD)
                .append(snitchReferee, game.snitchReferee)
                .append(snitch, game.snitch)
                .append(pitch, game.pitch)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(timeslot)
                .append(teamA)
                .append(teamB)
                .append(headReferee)
                .append(assistantRefereeA)
                .append(assistantRefereeB)
                .append(assistantRefereeC)
                .append(assistantRefereeD)
                .append(snitchReferee)
                .append(snitch)
                .append(pitch)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("timeslot", timeslot)
                .append("teamA", teamA)
                .append("teamB", teamB)
                .append("headReferee", headReferee)
                .append("assistantRefereeA", assistantRefereeA)
                .append("assistantRefereeB", assistantRefereeB)
                .append("assistantRefereeC", assistantRefereeC)
                .append("assistantRefereeD", assistantRefereeD)
                .append("snitchReferee", snitchReferee)
                .append("snitch", snitch)
                .append("pitch", pitch)
                .toString();
    }
}
