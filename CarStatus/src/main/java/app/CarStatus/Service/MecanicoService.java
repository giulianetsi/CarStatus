package app.CarStatus.Service;

import app.CarStatus.DTO.MecanicoDTO;
import app.CarStatus.Entity.MecanicoEntity;
import app.CarStatus.Mapper.MecanicoMapper;
import app.CarStatus.Repository.MecanicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MecanicoService {
    @Autowired
    private MecanicoRepository repository;

    @Transactional( rollbackFor = Exception.class )
    public MecanicoDTO save(MecanicoEntity mecanico){
        MecanicoEntity novoMecanico = salvarEEditar( mecanico );
        return MecanicoMapper.converterParaDTO( novoMecanico );
    }

    @Transactional( rollbackFor = Exception.class )
    public MecanicoDTO editar(MecanicoEntity mecanico, Long id ){
        mecanico.setId( id );
        MecanicoEntity novoMecanico = salvarEEditar( mecanico );
        return MecanicoMapper.converterParaDTO(novoMecanico);
    }

    public MecanicoDTO buscarPorId(Long id ){
        return MecanicoMapper.converterParaDTO( repository.findById( id ).get() );
    }

    public List<MecanicoDTO> buscarTodos(){
        return MecanicoMapper.converterListaParaDTO( repository.findAll() );
    }

    public MecanicoEntity salvarEEditar(MecanicoEntity mecanico ){
        return repository.save(mecanico);
    }

    public void deletarPorId( Long id ){
        repository.deleteById( id );
    }
}
