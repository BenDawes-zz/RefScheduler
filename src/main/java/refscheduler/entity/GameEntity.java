package refscheduler.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Game entity.
 */
@Entity
@Table(name = "GAME")
public class GameEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GAME_ID")
    private Long gameId;

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

    @ManyToOne
    @JoinColumn(name = "ASSISTANT_REFEREE_A_ID")
    private PersonEntity assistantRefereeA;

    @ManyToOne
    @JoinColumn(name = "ASSISTANT_REFEREE_B_ID")
    private PersonEntity assistantRefereeB;

    @ManyToOne
    @JoinColumn(name = "ASSISTANT_REFEREE_C_ID")
    private PersonEntity assistantRefereeC;

    @ManyToOne
    @JoinColumn(name = "ASSISTANT_REFEREE_D_ID")
    private PersonEntity assistantRefereeD;

    @ManyToOne
    @JoinColumn(name = "SNITCH_REFEREE_ID")
    private PersonEntity snitchReferee;

    @ManyToOne
    @JoinColumn(name = "SNITCH_ID")
    private PersonEntity snitch;

    @Column(name = "PITCH")
    private Long pitch;

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
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

    public PersonEntity getAssistantRefereeA() {
        return assistantRefereeA;
    }

    public void setAssistantRefereeA(PersonEntity assistantRefereeA) {
        this.assistantRefereeA = assistantRefereeA;
    }

    public PersonEntity getAssistantRefereeB() {
        return assistantRefereeB;
    }

    public void setAssistantRefereeB(PersonEntity assistantRefereeB) {
        this.assistantRefereeB = assistantRefereeB;
    }

    public PersonEntity getAssistantRefereeC() {
        return assistantRefereeC;
    }

    public void setAssistantRefereeC(PersonEntity assistantRefereeC) {
        this.assistantRefereeC = assistantRefereeC;
    }

    public PersonEntity getAssistantRefereeD() {
        return assistantRefereeD;
    }

    public void setAssistantRefereeD(PersonEntity assistantRefereeD) {
        this.assistantRefereeD = assistantRefereeD;
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
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        GameEntity that = (GameEntity) o;

        return new EqualsBuilder()
                .append(gameId, that.gameId)
                .append(teamA, that.teamA)
                .append(teamB, that.teamB)
                .append(timeslot, that.timeslot)
                .append(headReferee, that.headReferee)
                .append(assistantRefereeA, that.assistantRefereeA)
                .append(assistantRefereeB, that.assistantRefereeB)
                .append(assistantRefereeC, that.assistantRefereeC)
                .append(assistantRefereeD, that.assistantRefereeD)
                .append(snitchReferee, that.snitchReferee)
                .append(snitch, that.snitch)
                .append(pitch, that.pitch)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(gameId)
                .append(teamA)
                .append(teamB)
                .append(timeslot)
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
                .append("gameId", gameId)
                .append("teamA", teamA)
                .append("teamB", teamB)
                .append("timeslot", timeslot)
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
