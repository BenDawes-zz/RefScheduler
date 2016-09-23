package refscheduler.util;

import org.dozer.CustomConverter;
import org.joda.time.DateTime;

import java.util.Date;

/**
 * Converts between Joda DateTime and Java Date.
 */
public class JodaDateTimeDateConvertor implements CustomConverter {

    @Override
    public Object convert(Object source, Object destination, Class<?> sourceClass, Class<?> destClass) {
        if (source == null) {
            return null;
        }

        if (source instanceof DateTime) {
            return ((DateTime) source).toDate();
        } else if (source instanceof Date) {
            return new DateTime(source);
        }

        return null;
    }
}
