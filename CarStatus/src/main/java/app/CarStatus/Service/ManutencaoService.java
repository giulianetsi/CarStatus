package app.CarStatus.Service;

import app.CarStatus.DTO.ManutencaoDTO;
import app.CarStatus.Entity.Enum.StatusEnum;
import app.CarStatus.Entity.ManutencaoEntity;
import app.CarStatus.Mapper.ManutencaoMapper;
import app.CarStatus.Repository.ManutencaoRepository;
import app.CarStatus.Repository.MecanicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
public class ManutencaoService {
    @Autowired
    private ManutencaoRepository repository;

    @Autowired
    private MecanicoRepository mecanicoRepository;

    @Transactional( rollbackFor = Exception.class )
    public ManutencaoDTO save(ManutencaoEntity manutencao){
        manutencao.setMecanico(mecanicoRepository.findById(manutencao.getMecanico().getId()).get());
        manutencao.setStatus(StatusEnum.NAO_INICIADA);
        manutencao.setValor(this.calcularValor(manutencao));
        ManutencaoEntity novaManutencao = salvarEEditar( manutencao );
        return ManutencaoMapper.converterParaDTO( novaManutencao );
    }

    @Transactional( rollbackFor = Exception.class )
    public ManutencaoDTO editar(ManutencaoEntity manutencao, Long id ){
        manutencao.setId( id );
        ManutencaoEntity novaManutencao = salvarEEditar( manutencao );
        return ManutencaoMapper.converterParaDTO(novaManutencao);
    }

    public ManutencaoDTO buscarPorId(Long id ){
        return ManutencaoMapper.converterParaDTO( repository.findById( id ).get() );
    }

    public List<ManutencaoDTO> buscarTodosPorIdDoCliente(Long id){
        return ManutencaoMapper.converterListaParaDTO(repository.findAllByCliente_Id(id));
    }

    public List<ManutencaoDTO> buscarTodosPorIdDoMecanico(Long id){
        return ManutencaoMapper.converterListaParaDTO(repository.findAllByMecanico_Id(id));
    }

    public List<ManutencaoDTO> buscarTodos(){
        return ManutencaoMapper.converterListaParaDTO( repository.findAll() );
    }

    public ManutencaoEntity salvarEEditar(ManutencaoEntity manutencao ){
        return repository.save(manutencao);
    }

    public void deletarPorId( Long id ){
        repository.deleteById( id );
    }

    private Double calcularValor(ManutencaoEntity manutencao){
        Double valorHoraMecanico = manutencao.getMecanico().getPrecoHora();
        Long diasDeManutencao = DAYS.between(manutencao.getDataInicio(), manutencao.getDataFinalizacao());
        return (diasDeManutencao * 8) * valorHoraMecanico;
    }
}
