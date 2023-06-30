package app.CarStatus.Mapper;

import app.CarStatus.DTO.ManutencaoDTO;
import app.CarStatus.DTO.MecanicoDTO;
import app.CarStatus.Entity.ManutencaoEntity;

import java.util.ArrayList;
import java.util.List;

public class ManutencaoMapper {
    public static ManutencaoEntity converterParaEntity(ManutencaoDTO manutencao ){
        ManutencaoEntity novaManutencao = new ManutencaoEntity();
        novaManutencao.setId(manutencao.getId());
        novaManutencao.setCarro(CarroMapper.converterParaEntity(manutencao.getCarro()));
        novaManutencao.setCliente(ClienteMapper.converterParaEntity(manutencao.getCliente()));
        novaManutencao.setMecanico(MecanicoMapper.converterParaEntity(manutencao.getMecanico()));
        novaManutencao.setProblema(manutencao.getProblema());
        novaManutencao.setDataFinalizacao(manutencao.getDataFinalizacao());
        novaManutencao.setDataInicio(manutencao.getDataInicio());
        novaManutencao.setStatus(manutencao.getStatus());
        novaManutencao.setValor(manutencao.getValor());
        return novaManutencao;
    }

    public static ManutencaoDTO converterParaDTO(ManutencaoEntity manutencaoEntity){
        ManutencaoDTO manutencaoDTO = new ManutencaoDTO();
        manutencaoDTO.setId(manutencaoEntity.getId());
        manutencaoDTO.setCarro(CarroMapper.converterParaDTO(manutencaoEntity.getCarro()));
        manutencaoDTO.setCliente(ClienteMapper.converterParaDTO(manutencaoEntity.getCliente()));
        manutencaoDTO.setMecanico(MecanicoMapper.converterParaDTO(manutencaoEntity.getMecanico()));
        manutencaoDTO.setProblema(manutencaoEntity.getProblema());
        manutencaoDTO.setDataFinalizacao(manutencaoEntity.getDataFinalizacao());
        manutencaoDTO.setDataInicio(manutencaoEntity.getDataInicio());
        manutencaoDTO.setStatus(manutencaoEntity.getStatus());
        manutencaoDTO.setValor(manutencaoEntity.getValor());
        return manutencaoDTO;
    }

    public static List<ManutencaoDTO> converterListaParaDTO(List<ManutencaoEntity> listaEntity){
        List<ManutencaoDTO> listaDTO = new ArrayList<>();
        for(ManutencaoEntity manutencao : listaEntity){
            listaDTO.add( ManutencaoMapper.converterParaDTO( manutencao ));
        }
        return listaDTO;
    }

    public static List<ManutencaoEntity> converterListaParaEntityO(List<ManutencaoDTO> listaDTO){
        List<ManutencaoEntity> listaEntity = new ArrayList<>();
        for(ManutencaoDTO manutencao : listaDTO){
            listaEntity.add( ManutencaoMapper.converterParaEntity( manutencao ));
        }
        return listaEntity;
    }
}
