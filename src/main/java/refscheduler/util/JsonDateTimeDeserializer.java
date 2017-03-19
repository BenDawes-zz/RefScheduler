package refscheduler.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import java.io.IOException;

/**
 * Json DateTime deserializer.
 */
public class JsonDateTimeDeserializer extends JsonDeserializer<DateTime> {

    private final static String pattern = "yyyy-MM-dd hh:mm:ss.SSS";

    @Override
    public DateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        return DateTime.parse(jsonParser.getText(), DateTimeFormat.forPattern(pattern));
    }
}
