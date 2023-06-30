package app.CarStatus.Repository;

import app.CarStatus.Entity.MecanicoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MecanicoRepository extends CrudRepository<MecanicoEntity, Long> {
    MecanicoEntity save(MecanicoEntity pessoa);

    Optional<MecanicoEntity> findById(Long id);

    List<MecanicoEntity> findAll();
}
