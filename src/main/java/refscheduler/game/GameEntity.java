package refscheduler.game;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import refscheduler.person.PersonEntity;
import refscheduler.team.TeamEntity;
import refscheduler.timeslot.TimeslotEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * game entity.
 */
@Entity
@Table(name = "GAME")
public class GameEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GAME_ID")
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "TEAM_A_ID")
    private TeamEntity teamA;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "TEAM_B_ID")
    private TeamEntity teamB;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "TIMESLOT_ID")
    private TimeslotEntity timeslot;

    @ManyToOne
    @JoinColumn(name = "HEAD_REFEREE_ID")
    private PersonEntity headReferee;

    @ManyToMany
    @JoinTable(
            name = "GAME_ASSISTANT_REFEREE",
            joinColumns = @JoinColumn(name = "GAME_ID", referencedColumnName = "GAME_ID"),
            inverseJoinColumns = @JoinColumn(name = "PERSON_ID", referencedColumnName = "PERSON_ID"))
    private List<PersonEntity> assistantReferees;

    @ManyToOne
    @JoinColumn(name = "SNITCH_REFEREE_ID")
    private PersonEntity snitchReferee;

    @ManyToOne
    @JoinColumn(name = "SNITCH_ID")
    private PersonEntity snitch;

    @Column(name = "PITCH")
    private Long pitch;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TeamEntity getTeamA() {
        return teamA;
    }

    public void setTeamA(TeamEntity teamA) {
        this.teamA = teamA;
    }

    public TeamEntity getTeamB() {
        return teamB;
    }

    public void setTeamB(TeamEntity teamB) {
        this.teamB = teamB;
    }

    public TimeslotEntity getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(TimeslotEntity time) {
        this.timeslot = time;
    }

    public PersonEntity getHeadReferee() {
        return headReferee;
    }

    public void setHeadReferee(PersonEntity headReferee) {
        this.headReferee = headReferee;
    }

    public List<PersonEntity> getAssistantReferees() {
        return assistantReferees;
    }

    public void setAssistantReferees(final List<PersonEntity> assistantReferees) {
        this.assistantReferees = assistantReferees;
    }

    public PersonEntity getSnitchReferee() {
        return snitchReferee;
    }

    public void setSnitchReferee(PersonEntity snitchReferee) {
        this.snitchReferee = snitchReferee;
    }

    public PersonEntity getSnitch() {
        return snitch;
    }

    public void setSnitch(PersonEntity snitch) {
        this.snitch = snitch;
    }

    public Long getPitch() {
        return pitch;
    }

    public void setPitch(Long pitch) {
        this.pitch = pitch;
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
