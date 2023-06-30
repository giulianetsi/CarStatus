package app.CarStatus.Controller;

import app.CarStatus.DTO.ClienteDTO;
import app.CarStatus.Mapper.ClienteMapper;
import app.CarStatus.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( value = "api/cliente" )
public class ClienteController {
    @Autowired
    private ClienteService service;

    @PostMapping
    public ResponseEntity<Object> salvarPessoa( @RequestBody ClienteDTO cliente ){
        try {
            boolean isTelefoneValido = service.validarTelefone(cliente.getTelefone());
            if (isTelefoneValido) {
                return new ResponseEntity<>(service.save(ClienteMapper.converterParaEntity(cliente)), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>("Telefone inválido", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> editarPessoa(@RequestBody ClienteDTO cliente, @PathVariable Long id ){
        try{
            return new ResponseEntity<>( service.editar( ClienteMapper.converterParaEntity(cliente), id ), HttpStatus.OK );
        }catch (Exception e){
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> buscarTodasPessoas(){
        try {
            return new ResponseEntity<>( service.buscarTodos(), HttpStatus.OK );
        }catch (Exception e){
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

    @GetMapping( "/{id}" )
    public ResponseEntity<Object> buscarPessoaPorId( @PathVariable Long id ) {
        try{
            return new ResponseEntity<>( service.buscarPorId( id ), HttpStatus.OK );
        }catch(Exception e){
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public void deletarPessoaPorId( @PathVariable Long id ) {
        service.deletarPorId(id);
    }
}
