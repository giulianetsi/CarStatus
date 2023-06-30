package app.CarStatus.Mapper;

import app.CarStatus.DTO.ClienteDTO;

import java.util.ArrayList;
import java.util.List;

public class ClienteMapper {
    public static app.CarStatus.Entity.ClienteEntity converterParaEntity(ClienteDTO cliente ){
        app.CarStatus.Entity.ClienteEntity novaPessoa = new app.CarStatus.Entity.ClienteEntity();
        novaPessoa.setId(cliente.getId());
        novaPessoa.setNome(cliente.getNome());
        novaPessoa.setCpf(cliente.getCpf());
        novaPessoa.setTelefone(cliente.getTelefone());
        novaPessoa.setCarros( cliente.getCarros() != null ? CarroMapper.converterListaParaEntity(cliente.getCarros()) : null );
        return novaPessoa;
    }

    public static ClienteDTO converterParaDTO(app.CarStatus.Entity.ClienteEntity clienteEntity){
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(clienteEntity.getId());
        clienteDTO.setNome(clienteEntity.getNome());
        clienteDTO.setCpf(clienteEntity.getCpf());
        clienteDTO.setTelefone(clienteEntity.getTelefone());
        return clienteDTO;
    }

    public static List<ClienteDTO> converterListaParaDTO(List<app.CarStatus.Entity.ClienteEntity> listaEntity){
        List<ClienteDTO> listaDTO = new ArrayList<>();
        for(app.CarStatus.Entity.ClienteEntity cliente : listaEntity){
            listaDTO.add( ClienteMapper.converterParaDTO( cliente ));
        }
        return listaDTO;
    }

    public static List<app.CarStatus.Entity.ClienteEntity> converterListaParaEntityO(List<ClienteDTO> listaDTO){
        List<app.CarStatus.Entity.ClienteEntity> listaEntity = new ArrayList<>();
        for(ClienteDTO pessoa : listaDTO){
            listaEntity.add( ClienteMapper.converterParaEntity( pessoa ));
        }
        return listaEntity;
    }
}
