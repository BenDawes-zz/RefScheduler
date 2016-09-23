package refscheduler.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import refscheduler.entity.GameEntity;

/**
 * Game repository.
 */
@Repository
public interface GameRepository extends CrudRepository<GameEntity, Long> {
}
