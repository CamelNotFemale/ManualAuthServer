package camelnotfemale.auth.data;

import camelnotfemale.auth.entities.ClientEntity;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<ClientEntity, String> {
}