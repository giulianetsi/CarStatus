package app.CarStatus.Controller;

import app.CarStatus.DTO.MecanicoDTO;
import app.CarStatus.Mapper.MecanicoMapper;
import app.CarStatus.Service.MecanicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( value = "api/mecanico" )
public class MecanicoController {
    @Autowired
    private MecanicoService service;

    @PostMapping
    public ResponseEntity<Object> salvarMecanico(@RequestBody MecanicoDTO mecanico ){
        try{
            return new ResponseEntity<>( service.save( MecanicoMapper.converterParaEntity(mecanico) ), HttpStatus.CREATED );
        }catch (Exception e){
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> editarMecanico(@RequestBody MecanicoDTO mecanico, @PathVariable Long id ){
        try{
            return new ResponseEntity<>( service.editar( MecanicoMapper.converterParaEntity(mecanico), id ), HttpStatus.OK );
        }catch (Exception e){
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

    @GetMapping
    public ResponseEntity<List<MecanicoDTO>> buscarTodosMecanicos(){
        try {
            return new ResponseEntity<>( service.buscarTodos(), HttpStatus.OK );
        }catch (Exception e){
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

    @GetMapping( "/{id}" )
    public ResponseEntity<Object> buscarMecanicoPorId( @PathVariable Long id ) {
        try{
            return new ResponseEntity<>( service.buscarPorId( id ), HttpStatus.OK );
        }catch(Exception e){
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public void deletarMecanicoPorId( @PathVariable Long id ) {
        service.deletarPorId(id);
    }
}
