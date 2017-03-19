package refscheduler.game;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * game Create/Update DTO.
 */
public class GameCrupdate {

    private Long id;

    private Long timeslot;

    private Long teamA;

    private Long teamB;

    private Long headReferee;

    private Long assistantRefereeA;

    private Long assistantRefereeB;

    private Long assistantRefereeC;

    private Long assistantRefereeD;

    private Long snitchReferee;

    private Long snitch;

    private Long pitch;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(final Long timeslot) {
        this.timeslot = timeslot;
    }

    public Long getTeamA() {
        return teamA;
    }

    public void setTeamA(Long teamA) {
        this.teamA = teamA;
    }

    public Long getTeamB() {
        return teamB;
    }

    public void setTeamB(Long teamB) {
        this.teamB = teamB;
    }

    public Long getHeadReferee() {
        return headReferee;
    }

    public void setHeadReferee(Long headReferee) {
        this.headReferee = headReferee;
    }

    public Long getAssistantRefereeA() {
        return assistantRefereeA;
    }

    public void setAssistantRefereeA(Long assistantRefereeA) {
        this.assistantRefereeA = assistantRefereeA;
    }

    public Long getAssistantRefereeB() {
        return assistantRefereeB;
    }

    public void setAssistantRefereeB(Long assistantRefereeB) {
        this.assistantRefereeB = assistantRefereeB;
    }

    public Long getAssistantRefereeC() {
        return assistantRefereeC;
    }

    public void setAssistantRefereeC(Long assistantRefereeC) {
        this.assistantRefereeC = assistantRefereeC;
    }

    public Long getAssistantRefereeD() {
        return assistantRefereeD;
    }

    public void setAssistantRefereeD(Long assistantRefereeD) {
        this.assistantRefereeD = assistantRefereeD;
    }

    public Long getSnitchReferee() {
        return snitchReferee;
    }

    public void setSnitchReferee(Long snitchReferee) {
        this.snitchReferee = snitchReferee;
    }

    public Long getSnitch() {
        return snitch;
    }

    public void setSnitch(Long snitch) {
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

        GameCrupdate game = (GameCrupdate) o;

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
