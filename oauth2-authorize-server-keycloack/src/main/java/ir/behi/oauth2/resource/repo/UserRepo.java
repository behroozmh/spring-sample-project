package ir.behi.oauth2.resource.repo;

import ir.behi.oauth2.resource.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<UserEntity,Long> {
}
