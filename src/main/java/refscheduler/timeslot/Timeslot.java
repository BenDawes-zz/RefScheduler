package refscheduler.timeslot;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.joda.time.DateTime;
import refscheduler.util.JsonDateTimeDeserializer;
import refscheduler.util.JsonDateTimeSerializer;

/**
 * Timeslot GET DTO.
 */
public class Timeslot {

    private Long id;

    @JsonSerialize(using = JsonDateTimeSerializer.class)
    @JsonDeserialize(using = JsonDateTimeDeserializer.class)
    private DateTime time;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

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

        final Timeslot that = (Timeslot) o;

        return new EqualsBuilder()
                .append(id, that.id)
                .append(time, that.time)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(time)
                .toHashCode();
    }
}
