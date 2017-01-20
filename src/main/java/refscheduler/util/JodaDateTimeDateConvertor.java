package refscheduler.util;

import org.dozer.DozerConverter;
import org.joda.time.DateTime;

import java.util.Date;

/**
 * Converts between Joda DateTime and Java Date.
 */
public class JodaDateTimeDateConvertor extends DozerConverter<Date, DateTime> {

    public JodaDateTimeDateConvertor(final Class<Date> prototypeA, final Class<DateTime> prototypeB) {
        super(prototypeA, prototypeB);
    }

    @Override
    public DateTime convertTo(final Date date, final DateTime dateTime) {
        return new DateTime(date);
    }

    @Override
    public Date convertFrom(final DateTime dateTime, final Date date) {
        return dateTime.toDate();
    }
}
