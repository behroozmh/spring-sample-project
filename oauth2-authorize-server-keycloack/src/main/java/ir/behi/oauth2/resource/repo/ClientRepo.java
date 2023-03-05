package ir.behi.oauth2.resource.repo;

import ir.behi.oauth2.resource.entity.ClientEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepo extends CrudRepository<ClientEntity, Long> {
}
