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
 * Game GET DTO.
 */
public class GameGet {

    private Long id;

    private TeamGet teamA;

    private TeamGet teamB;

    @JsonSerialize(using = JsonDateTimeSerializer.class)
    @JsonDeserialize(using = JsonDateTimeDeserializer.class)
    private DateTime time;

    private PersonGet headReferee;

    private PersonGet assistantRefereeA;

    private PersonGet assistantRefereeB;

    private PersonGet assistantRefereeC;

    private PersonGet assistantRefereeD;

    private PersonGet snitchReferee;

    private PersonGet snitch;

    private Long pitch;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TeamGet getTeamA() {
        return teamA;
    }

    public void setTeamA(TeamGet teamA) {
        this.teamA = teamA;
    }

    public TeamGet getTeamB() {
        return teamB;
    }

    public void setTeamB(TeamGet teamB) {
        this.teamB = teamB;
    }

    public DateTime getTime() {
        return time;
    }

    public void setTime(DateTime time) {
        this.time = time;
    }

    public PersonGet getHeadReferee() {
        return headReferee;
    }

    public void setHeadReferee(PersonGet headReferee) {
        this.headReferee = headReferee;
    }

    public PersonGet getAssistantRefereeA() {
        return assistantRefereeA;
    }

    public void setAssistantRefereeA(PersonGet assistantRefereeA) {
        this.assistantRefereeA = assistantRefereeA;
    }

    public PersonGet getAssistantRefereeB() {
        return assistantRefereeB;
    }

    public void setAssistantRefereeB(PersonGet assistantRefereeB) {
        this.assistantRefereeB = assistantRefereeB;
    }

    public PersonGet getAssistantRefereeC() {
        return assistantRefereeC;
    }

    public void setAssistantRefereeC(PersonGet assistantRefereeC) {
        this.assistantRefereeC = assistantRefereeC;
    }

    public PersonGet getAssistantRefereeD() {
        return assistantRefereeD;
    }

    public void setAssistantRefereeD(PersonGet assistantRefereeD) {
        this.assistantRefereeD = assistantRefereeD;
    }

    public PersonGet getSnitchReferee() {
        return snitchReferee;
    }

    public void setSnitchReferee(PersonGet snitchReferee) {
        this.snitchReferee = snitchReferee;
    }

    public PersonGet getSnitch() {
        return snitch;
    }

    public void setSnitch(PersonGet snitch) {
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

        GameGet gameGet = (GameGet) o;

        return new EqualsBuilder()
                .append(id, gameGet.id)
                .append(teamA, gameGet.teamA)
                .append(teamB, gameGet.teamB)
                .append(time, gameGet.time)
                .append(headReferee, gameGet.headReferee)
                .append(assistantRefereeA, gameGet.assistantRefereeA)
                .append(assistantRefereeB, gameGet.assistantRefereeB)
                .append(assistantRefereeC, gameGet.assistantRefereeC)
                .append(assistantRefereeD, gameGet.assistantRefereeD)
                .append(snitchReferee, gameGet.snitchReferee)
                .append(snitch, gameGet.snitch)
                .append(pitch, gameGet.pitch)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
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
                .append("id", id)
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
