package refscheduler.timeslot;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import refscheduler.util.DozerMapper;

import java.util.List;

/**
 * Timeslot scheduler.
 */
@Service("timeslotService")
public class TimeslotService {

    @Autowired
    private DozerMapper mapper;

    @Autowired
    private TimeslotRepository timeslotRepository;

    public Long save(final Timeslot timeslot) {
        final TimeslotEntity entity = mapper.map(timeslot, TimeslotEntity.class);

        timeslotRepository.save(entity);

        return entity.getId();
    }

    public Timeslot getTimeslot(final Long timeslotId) {
        final TimeslotEntity entity = timeslotRepository.findOne(timeslotId);

        return mapper.map(entity, Timeslot.class);
    }

    public Timeslot getTimeslotByTime(final DateTime time) {
        final TimeslotEntity entity = timeslotRepository.findByTime(time.toDate());

        return mapper.map(entity, Timeslot.class);
    }

    public List<Timeslot> getAllTimeslots() {
        final List<TimeslotEntity> entities = timeslotRepository.findAll();

        return mapper.map(entities, Timeslot.class);
    }

    public void delete(final Long timeslotId) {
        timeslotRepository.delete(timeslotId);
    }
}
