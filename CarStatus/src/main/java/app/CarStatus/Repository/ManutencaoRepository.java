package app.CarStatus.Repository;

import app.CarStatus.Entity.ManutencaoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ManutencaoRepository extends CrudRepository<ManutencaoEntity, Long> {
    ManutencaoEntity save(ManutencaoEntity manutencao);

    Optional<ManutencaoEntity> findById(Long id);

    List<ManutencaoEntity> findAllByCliente_Id(Long id);

    List<ManutencaoEntity> findAllByMecanico_Id(Long id);

    List<ManutencaoEntity> findAll();
}
