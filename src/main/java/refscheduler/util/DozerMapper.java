package refscheduler.util;

import org.dozer.CustomConverter;
import org.dozer.DozerBeanMapper;
import org.dozer.MappingException;
import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static java.util.Collections.singletonList;

/**
 * Created by Eamonn on 11/09/2016.
 */
@Component("mapper")
public class DozerMapper {

    private DozerBeanMapper mapper;

    public DozerMapper() {
        mapper = new DozerBeanMapper(Collections.singletonList("mappings.xml"));
        List<CustomConverter> converters = singletonList(new JodaDateTimeDateConvertor(Date.class, DateTime.class));
        mapper.setCustomConverters(converters);
    }

    public <T> T map(Object var1, Class<T> var2) throws MappingException {
        return mapper.map(var1, var2);
    }

    public void map(Object var1, Object var2) throws MappingException {
        mapper.map(var1, var2);
    }

    public <T> T map(Object var1, Class<T> var2, String var3) throws MappingException {
        return mapper.map(var1, var2);
    }

    public void map(Object var1, Object var2, String var3) throws MappingException {
        mapper.map(var1, var2);
    }

    public <S, D> List<D> map(List<S> var1, Class<D> var2) {
        List<D> dest = new ArrayList<>();
        for (S s : var1) {
            dest.add(mapper.map(s, var2));
        }
        return dest;
    }
}
