package refscheduler.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.joda.time.DateTime;

import java.util.List;

/**
 * Timeslot GET DTO.
 */
public class TimeslotGet {

    private Long timeslotId;

    private DateTime time;

    private List<GameGet> games;

    public Long getTimeslotId() {
        return timeslotId;
    }

    public void setTimeslotId(final Long timeslotId) {
        this.timeslotId = timeslotId;
    }

    public DateTime getTime() {
        return time;
    }

    public void setTime(final DateTime time) {
        this.time = time;
    }

    public List<GameGet> getGames() {
        return games;
    }

    public void setGames(final List<GameGet> games) {
        this.games = games;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        final TimeslotGet that = (TimeslotGet) o;

        return new EqualsBuilder()
                .append(timeslotId, that.timeslotId)
                .append(time, that.time)
                .append(games, that.games)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(timeslotId)
                .append(time)
                .append(games)
                .toHashCode();
    }
}
