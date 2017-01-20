package refscheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import refscheduler.entity.TeamEntity;

/**
 * The team repository.
 */
@Repository
public interface TeamRepository extends JpaRepository<TeamEntity, Long> {
}
