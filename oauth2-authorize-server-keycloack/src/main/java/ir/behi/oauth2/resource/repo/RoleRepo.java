package ir.behi.oauth2.resource.repo;

import ir.behi.oauth2.resource.entity.RoleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends CrudRepository<RoleEntity, Long> {
}
