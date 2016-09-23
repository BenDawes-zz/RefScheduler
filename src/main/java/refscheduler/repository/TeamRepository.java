package refscheduler.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import refscheduler.entity.TeamEntity;

/**
 * The team repository.
 */
@Repository
public interface TeamRepository extends CrudRepository<TeamEntity, Long> {
}
