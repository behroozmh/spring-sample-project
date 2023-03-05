package ir.behi.oauth2.resource.repo;

import ir.behi.oauth2.resource.entity.PersonEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepo extends CrudRepository<PersonEntity, Long> {
    PersonEntity findPersonEntityById(Long id);
}
