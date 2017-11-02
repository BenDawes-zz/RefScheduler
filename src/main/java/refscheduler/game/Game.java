package refscheduler.game;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import refscheduler.person.Person;
import refscheduler.team.Team;
import refscheduler.timeslot.Timeslot;
import refscheduler.tournament.Tournament;

import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.List;

/**
 * game GET DTO.
 */
public class Game {

    private Long id;

    @NotNull
    private Tournament tournament;

    @NotNull
    private Timeslot timeslot;

    @NotNull
    private Team teamA;

    @NotNull
    private Team teamB;

    private Person headReferee;

    private List<Person> assistantReferees;

    private Person snitchReferee;

    private Person snitch;

    private Long pitch;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
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

    public List<Person> getAssistantReferees() {
        return assistantReferees;
    }

    public void setAssistantReferees(final List<Person> assistantReferees) {
        this.assistantReferees = assistantReferees;
    }

    public void addAssistantReferee(final Person referee) {
        assistantReferees.add(referee);
    }

    public void removeAssistantReferee(final Person referee) {
        assistantReferees.remove(referee);
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

    @JsonIgnore
    public List<Person> getGameOfficials() {
        List<Person> refs =  Arrays.asList(
                headReferee,
                snitchReferee,
                snitch
        );
        refs.addAll(assistantReferees);
        return refs;
    }

    public boolean involvesTeam(Team team) {
        return  team != null && (teamA.equals(team) || teamB.equals(team));
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
