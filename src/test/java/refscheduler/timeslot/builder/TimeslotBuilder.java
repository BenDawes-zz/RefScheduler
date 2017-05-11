package refscheduler.timeslot.builder;

import org.joda.time.DateTime;
import refscheduler.timeslot.Timeslot;

public class TimeslotBuilder {

    private Long id;
    private DateTime time;

    private TimeslotBuilder () {

    }

    public static TimeslotBuilder newTimeslot() {
        return new TimeslotBuilder();
    }

    public TimeslotBuilder withId(final Long id) {
        this.id = id;
        return this;
    }

    public TimeslotBuilder withTime(final DateTime time) {
        this.time = time;
        return this;
    }

    public Timeslot build() {
        Timeslot timeslot = new Timeslot();
        timeslot.setId(id);
        timeslot.setTime(time);
        return timeslot;
    }
}
