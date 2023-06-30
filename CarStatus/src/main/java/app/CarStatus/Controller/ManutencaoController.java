package app.CarStatus.Controller;

import app.CarStatus.DTO.ManutencaoDTO;
import app.CarStatus.Entity.Enum.StatusEnum;
import app.CarStatus.Mapper.ManutencaoMapper;
import app.CarStatus.Service.ManutencaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( value = "api/manutencao" )
public class ManutencaoController {
    @Autowired
    private ManutencaoService service;

    @PostMapping
    public ResponseEntity<Object> salvarManutencao(@RequestBody ManutencaoDTO manutencao ){
        try{
            return new ResponseEntity<>( service.save( ManutencaoMapper.converterParaEntity(manutencao) ), HttpStatus.CREATED );
        }catch (Exception e){
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> editarManutencao(@RequestBody ManutencaoDTO manutencao, @PathVariable Long id ){
        try{
            return new ResponseEntity<>( service.editar( ManutencaoMapper.converterParaEntity(manutencao), id ), HttpStatus.OK );
        }catch (Exception e){
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<List<ManutencaoDTO>> buscarTodasManutencoesDeClientePorId(@PathVariable Long id){
        try {
            return new ResponseEntity<>( service.buscarTodosPorIdDoCliente(id), HttpStatus.OK );
        }catch (Exception e){
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

    @GetMapping("/mecanico/{id}")
    public ResponseEntity<List<ManutencaoDTO>> buscarTodasManutencoesDeMecanicoPorId(@PathVariable Long id){
        try {
            return new ResponseEntity<>( service.buscarTodosPorIdDoMecanico(id), HttpStatus.OK );
        }catch (Exception e){
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

    @GetMapping( "/{id}" )
    public ResponseEntity<Object> buscarManutencaoPorId( @PathVariable Long id ) {
        try{
            return new ResponseEntity<>( service.buscarPorId( id ), HttpStatus.OK );
        }catch(Exception e){
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public void deletarManutencaoPorId( @PathVariable Long id ) {
        service.deletarPorId(id);
    }

    @PostMapping("/{id}/iniciar")
    public ResponseEntity<Object> iniciarManutencao(@PathVariable Long id ){
        try{
            ManutencaoDTO manutencao = service.buscarPorId(id);
            manutencao.setStatus(StatusEnum.EM_ANDAMENTO);
            return new ResponseEntity<>( service.editar( ManutencaoMapper.converterParaEntity(manutencao), id ), HttpStatus.OK );
        }catch (Exception e){
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

    @PostMapping("/{id}/cancelar")
    public ResponseEntity<Object> cancelarManutencao(@PathVariable Long id ){
        try{
            ManutencaoDTO manutencao = service.buscarPorId(id);
            manutencao.setStatus(StatusEnum.CANCELADA);
            return new ResponseEntity<>( service.editar( ManutencaoMapper.converterParaEntity(manutencao), id ), HttpStatus.OK );
        }catch (Exception e){
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

    @PostMapping("/{id}/finalizar")
    public ResponseEntity<Object> finalizarManutencao(@RequestBody ManutencaoDTO manutencao, @PathVariable Long id ){
        try{
            manutencao.setStatus(StatusEnum.FINALIZADA);
            return new ResponseEntity<>( service.editar( ManutencaoMapper.converterParaEntity(manutencao), id ), HttpStatus.OK );
        }catch (Exception e){
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }
}
