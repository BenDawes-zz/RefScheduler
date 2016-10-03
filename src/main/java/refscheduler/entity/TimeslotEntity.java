package refscheduler.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.util.Date;

/**
 * Timeslot entity.
 */
@Entity
@Table(name = "TIMESLOT")
public class TimeslotEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TIMESLOT_ID")
    private Long timeslotId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "time")
    private Date time;

    public Long getTimeslotId() {
        return timeslotId;
    }

    public void setTimeslotId(final Long timeslotId) {
        this.timeslotId = timeslotId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(final Date time) {
        this.time = time;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        final TimeslotEntity that = (TimeslotEntity) o;

        return new EqualsBuilder()
                .append(timeslotId, that.timeslotId)
                .append(time, that.time)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(timeslotId)
                .append(time)
                .toHashCode();
    }
}
