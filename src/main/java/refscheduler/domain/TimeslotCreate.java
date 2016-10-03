package refscheduler.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.joda.time.DateTime;

import javax.validation.constraints.NotNull;

/**
 * Timeslot CREATE DTO.
 */
public class TimeslotCreate {

    @NotNull
    private DateTime time;

    public DateTime getTime() {
        return time;
    }

    public void setTime(final DateTime time) {
        this.time = time;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        final TimeslotCreate that = (TimeslotCreate) o;

        return new EqualsBuilder()
                .append(time, that.time)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(time)
                .toHashCode();
    }
}
