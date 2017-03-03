package refscheduler.team;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The team repository.
 */
@Repository
public interface TeamRepository extends JpaRepository<TeamEntity, Long> {
}
