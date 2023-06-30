package app.CarStatus.DTO;

import app.CarStatus.Entity.CarroEntity;
import app.CarStatus.Entity.ClienteEntity;
import app.CarStatus.Entity.Enum.StatusEnum;
import app.CarStatus.Entity.MecanicoEntity;

import java.time.LocalDate;

public class ManutencaoDTO {
    private Long id;
    private LocalDate dataInicio;
    private LocalDate dataFinalizacao;
    private ClienteDTO cliente;
    private MecanicoDTO mecanico;
    private CarroDTO carro;
    private Double valor;
    private String problema;
    private StatusEnum status;

    public ManutencaoDTO(Long id, LocalDate dataInicio, LocalDate dataFinalizacao, ClienteDTO cliente, MecanicoDTO mecanico, CarroDTO carro, Double valor, String problema, StatusEnum status) {
        this.id = id;
        this.dataInicio = dataInicio;
        this.dataFinalizacao = dataFinalizacao;
        this.cliente = cliente;
        this.mecanico = mecanico;
        this.carro = carro;
        this.valor = valor;
        this.problema = problema;
        this.status = status;
    }

    public ManutencaoDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFinalizacao() {
        return dataFinalizacao;
    }

    public void setDataFinalizacao(LocalDate dataFinalizacao) {
        this.dataFinalizacao = dataFinalizacao;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public MecanicoDTO getMecanico() {
        return mecanico;
    }

    public void setMecanico(MecanicoDTO mecanico) {
        this.mecanico = mecanico;
    }

    public CarroDTO getCarro() {
        return carro;
    }

    public void setCarro(CarroDTO carro) {
        this.carro = carro;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }
}
