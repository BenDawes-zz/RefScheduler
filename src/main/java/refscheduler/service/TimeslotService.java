package refscheduler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import refscheduler.domain.TimeslotCreate;
import refscheduler.domain.TimeslotGet;
import refscheduler.entity.TimeslotEntity;
import refscheduler.repository.TimeslotRepository;
import refscheduler.util.DozerMapper;

/**
 * Timeslot service.
 */
@Service("timeslotService")
public class TimeslotService {

    @Autowired
    private DozerMapper mapper;

    @Autowired
    private TimeslotRepository timeslotRepository;

    public Long createTimeslot(final TimeslotCreate timeslotCreate) {
        final TimeslotEntity entity = new TimeslotEntity();

        entity.setTime(timeslotCreate.getTime().toDate());

        timeslotRepository.save(entity);

        return entity.getTimeslotId();
    }

    public TimeslotGet findTimeslot(final Long timeslotId) {
        final TimeslotEntity entity = timeslotRepository.findOne(timeslotId);

        return mapper.map(entity, TimeslotGet.class);
    }
}
