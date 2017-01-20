package refscheduler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import refscheduler.domain.TimeslotCreate;
import refscheduler.domain.TimeslotGet;
import refscheduler.entity.TimeslotEntity;
import refscheduler.repository.TimeslotRepository;
import refscheduler.util.DozerMapper;

import java.util.List;

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

        return entity.getId();
    }

    public TimeslotGet getTimeslot(final Long timeslotId) {
        final TimeslotEntity entity = timeslotRepository.findOne(timeslotId);

        return mapper.map(entity, TimeslotGet.class);
    }

    public List<TimeslotGet> getAllTimeslots() {
        final List<TimeslotEntity> entities = timeslotRepository.findAll();

        return mapper.map(entities, TimeslotGet.class);
    }
}
