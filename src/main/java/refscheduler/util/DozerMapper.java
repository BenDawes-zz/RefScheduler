package refscheduler.util;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.dozer.MappingException;
import org.springframework.stereotype.Component;

import java.util.Collections;

/**
 * Created by Eamonn on 11/09/2016.
 */
@Component("mapper")
public class DozerMapper {

    private Mapper mapper;

    public DozerMapper() {
        mapper = new DozerBeanMapper(Collections.singletonList("mappings.xml"));
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
}
