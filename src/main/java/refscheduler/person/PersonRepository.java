package refscheduler.person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The person repository.
 */
@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
}
