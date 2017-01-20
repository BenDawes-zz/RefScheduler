package refscheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import refscheduler.entity.TimeslotEntity;

/**
 * Repository for Timeslot entities.
 */
public interface TimeslotRepository extends JpaRepository<TimeslotEntity, Long> {
}
