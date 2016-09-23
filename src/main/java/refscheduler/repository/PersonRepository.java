package refscheduler.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import refscheduler.entity.PersonEntity;

/**
 * The person repository.
 */
@Repository
public interface PersonRepository extends CrudRepository<PersonEntity, Long> {
}
