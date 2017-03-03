package refscheduler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import refscheduler.domain.Timeslot;
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

    public Long save(final Timeslot timeslot) {
        final TimeslotEntity entity = mapper.map(timeslot, TimeslotEntity.class);

        timeslotRepository.save(entity);

        return entity.getId();
    }

    public Timeslot getTimeslot(final Long timeslotId) {
        final TimeslotEntity entity = timeslotRepository.findOne(timeslotId);

        return mapper.map(entity, Timeslot.class);
    }

    public List<Timeslot> getAllTimeslots() {
        final List<TimeslotEntity> entities = timeslotRepository.findAll();

        return mapper.map(entities, Timeslot.class);
    }
}
