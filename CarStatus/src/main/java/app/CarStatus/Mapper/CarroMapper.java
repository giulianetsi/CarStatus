package app.CarStatus.Mapper;

import app.CarStatus.DTO.CarroDTO;
import app.CarStatus.Entity.CarroEntity;

import java.util.ArrayList;
import java.util.List;

public class CarroMapper {
    public static CarroEntity converterParaEntity(CarroDTO carro ){
        CarroEntity novoCarro = new CarroEntity();
        novoCarro.setId(carro.getId());
        novoCarro.setPlaca(carro.getPlaca());
        novoCarro.setMarca(carro.getMarca());
        novoCarro.setModelo(carro.getModelo());
        novoCarro.setDono(carro.getDono() == null ? null : ClienteMapper.converterParaEntity(carro.getDono()));
        return novoCarro;
    }

    public static CarroDTO converterParaDTO( CarroEntity carroEntity ){
        CarroDTO carroDTO = new CarroDTO();
        carroDTO.setId(carroEntity.getId());
        carroDTO.setPlaca(carroEntity.getPlaca());
        carroDTO.setMarca(carroEntity.getMarca());
        carroDTO.setModelo(carroEntity.getModelo());
        carroDTO.setDono(carroEntity.getDono() == null ? null : ClienteMapper.converterParaDTO(carroEntity.getDono()));
        return carroDTO;
    }

    public static List<CarroDTO> converterListaParaDTO(List<CarroEntity> listaEntity ){
        List<CarroDTO> listaDTO = new ArrayList<>();
        for(CarroEntity carro : listaEntity){
            listaDTO.add( CarroMapper.converterParaDTO( carro ));
        }
        return listaDTO;
    }

    public static List<CarroEntity> converterListaParaEntity(List<CarroDTO> listaDTO){
        List<CarroEntity> listaEntity = new ArrayList<>();
        for(CarroDTO carro : listaDTO){
            listaEntity.add( CarroMapper.converterParaEntity( carro ));
        }
        return listaEntity;
    }
}
