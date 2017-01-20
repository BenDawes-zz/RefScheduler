package refscheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import refscheduler.entity.GameEntity;

/**
 * Game repository.
 */
@Repository
public interface GameRepository extends JpaRepository<GameEntity, Long> {
}
