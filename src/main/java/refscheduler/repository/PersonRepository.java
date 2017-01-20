package refscheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import refscheduler.entity.PersonEntity;

/**
 * The person repository.
 */
@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
}
