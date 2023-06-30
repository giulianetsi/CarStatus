package app.CarStatus.Mapper;

import app.CarStatus.DTO.ClienteDTO;
import app.CarStatus.DTO.MecanicoDTO;
import app.CarStatus.Entity.ClienteEntity;
import app.CarStatus.Entity.MecanicoEntity;

import java.util.ArrayList;
import java.util.List;

public class MecanicoMapper {
    public static MecanicoEntity converterParaEntity(MecanicoDTO mecanico ){
        MecanicoEntity novoMecanico = new MecanicoEntity();
        novoMecanico.setId(mecanico.getId());
        novoMecanico.setNome(mecanico.getNome());
        novoMecanico.setCpf(mecanico.getCpf());
        novoMecanico.setTelefone(mecanico.getTelefone());
        novoMecanico.setPrecoHora(mecanico.getPrecoHora());
        return novoMecanico;
    }

    public static MecanicoDTO converterParaDTO(MecanicoEntity mecanicoEntity){
        MecanicoDTO mecanicoDTO = new MecanicoDTO();
        mecanicoDTO.setId(mecanicoEntity.getId());
        mecanicoDTO.setNome(mecanicoEntity.getNome());
        mecanicoDTO.setCpf(mecanicoEntity.getCpf());
        mecanicoDTO.setCpf(mecanicoEntity.getTelefone());
        mecanicoDTO.setPrecoHora(mecanicoEntity.getPrecoHora());
        return mecanicoDTO;
    }

    public static List<MecanicoDTO> converterListaParaDTO(List<MecanicoEntity> listaEntity){
        List<MecanicoDTO> listaDTO = new ArrayList<>();
        for(MecanicoEntity mecanico : listaEntity){
            listaDTO.add( MecanicoMapper.converterParaDTO( mecanico ));
        }
        return listaDTO;
    }

    public static List<MecanicoEntity> converterListaParaEntityO(List<MecanicoDTO> listaDTO){
        List<MecanicoEntity> listaEntity = new ArrayList<>();
        for(MecanicoDTO mecanico : listaDTO){
            listaEntity.add( MecanicoMapper.converterParaEntity( mecanico ));
        }
        return listaEntity;
    }
}
