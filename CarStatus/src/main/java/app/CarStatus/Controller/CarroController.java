package app.CarStatus.Controller;

import app.CarStatus.DTO.CarroDTO;
import app.CarStatus.Mapper.CarroMapper;
import app.CarStatus.Service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( value = "api/carro" )
public class CarroController {
    @Autowired
    private CarroService service;

    @PostMapping
    public ResponseEntity<Object> salvarCarro( @RequestBody CarroDTO carro ){
        try{
            return new ResponseEntity<>( service.save( CarroMapper.converterParaEntity(carro) ), HttpStatus.CREATED );
        }catch (Exception e){
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> editarCarro( @RequestBody CarroDTO carro, @PathVariable Long id ){
        try{
            return new ResponseEntity<>( service.editar( CarroMapper.converterParaEntity(carro), id ), HttpStatus.OK );
        }catch (Exception e){
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

    @GetMapping
    public ResponseEntity<List<CarroDTO>> buscarTodosCarros(){
        try {
            return new ResponseEntity<>( service.buscarTodos(), HttpStatus.OK );
        }catch (Exception e){
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

    @GetMapping("/dono/{id}")
    public ResponseEntity<List<CarroDTO>> buscarTodosPorIdDono( @PathVariable Long id){
        try {
            return new ResponseEntity<>( service.buscarTodosPorIdDono(id), HttpStatus.OK );
        }catch (Exception e){
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }


    @GetMapping( "/{id}" )
    public ResponseEntity<Object> buscarCarroPorId( @PathVariable Long id ) {
        try{
            return new ResponseEntity<>( service.buscarPorId( id ), HttpStatus.OK );
        }catch(Exception e){
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteKudoBoxById( @PathVariable Long id ) {
        service.deletarPorId(id);
    }
}
