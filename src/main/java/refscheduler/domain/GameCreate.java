package refscheduler.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.joda.time.DateTime;
import refscheduler.util.JsonDateTimeDeserializer;
import refscheduler.util.JsonDateTimeSerializer;

/**
 * Game CREATE DTO.
 */
public class GameCreate {

    private Long teamA;

    private Long teamB;

    @JsonSerialize(using = JsonDateTimeSerializer.class)
    @JsonDeserialize(using = JsonDateTimeDeserializer.class)
    private DateTime time;

    private Long headReferee;

    private Long assistantRefereeA;

    private Long assistantRefereeB;

    private Long assistantRefereeC;

    private Long assistantRefereeD;

    private Long snitchReferee;

    private Long snitch;

    private Long pitch;

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

    public DateTime getTime() {
        return time;
    }

    public void setTime(DateTime time) {
        this.time = time;
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

        GameCreate that = (GameCreate) o;

        return new EqualsBuilder()
                .append(teamA, that.teamA)
                .append(teamB, that.teamB)
                .append(time, that.time)
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
                .append(teamA)
                .append(teamB)
                .append(time)
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
                .append("teamA", teamA)
                .append("teamB", teamB)
                .append("time", time)
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
