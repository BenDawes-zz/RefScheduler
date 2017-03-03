package refscheduler.game;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * game repository.
 */
@Repository
public interface GameRepository extends JpaRepository<GameEntity, Long> {
}
