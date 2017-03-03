package refscheduler.timeslot;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for Timeslot entities.
 */
public interface TimeslotRepository extends JpaRepository<TimeslotEntity, Long> {
}
