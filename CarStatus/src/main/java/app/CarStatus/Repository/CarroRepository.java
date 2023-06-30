package app.CarStatus.Repository;
import app.CarStatus.Entity.CarroEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarroRepository extends CrudRepository<CarroEntity, Long> {
    CarroEntity save(CarroEntity pessoa);

    Optional<CarroEntity> findById(Long id);

    List<CarroEntity> findAll();

    List<CarroEntity> findAllByDono_Id(Long id);
}
