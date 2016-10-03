package refscheduler.repository;

import org.springframework.data.repository.CrudRepository;
import refscheduler.entity.TimeslotEntity;

/**
 * Repository for Timeslot entities.
 */
public interface TimeslotRepository extends CrudRepository<TimeslotEntity, Long> {
}
