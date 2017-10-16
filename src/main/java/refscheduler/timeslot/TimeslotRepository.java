package refscheduler.timeslot;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

/**
 * Repository for Timeslot entities.
 */
public interface TimeslotRepository extends JpaRepository<TimeslotEntity, Long> {

    TimeslotEntity findByTime(Date time);
}
