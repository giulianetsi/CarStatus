package app.CarStatus.Repository;

import app.CarStatus.Entity.ClienteEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends CrudRepository<ClienteEntity, Long> {
    ClienteEntity save(ClienteEntity cliente);

    Optional<ClienteEntity> findById(Long id);

    List<ClienteEntity> findAll();
}
