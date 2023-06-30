package app.CarStatus.Entity;

import app.CarStatus.Entity.Enum.StatusEnum;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class ManutencaoEntity {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( columnDefinition = "Long")
    private Long id;

    @Column(nullable = false)
    private LocalDate dataInicio;

    @Column(nullable = false)
    private LocalDate dataFinalizacao;

    @ManyToOne(fetch = FetchType.LAZY)
    private ClienteEntity cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    private MecanicoEntity mecanico;

    @ManyToOne(fetch = FetchType.LAZY)
    private CarroEntity carro;

    @Column(nullable = false)
    private Double valor;

    @Column(nullable = false)
    private String problema;

    @Column(nullable = false)
    private StatusEnum status;

    public ManutencaoEntity(Long id, LocalDate dataInicio, LocalDate dataFinalizacao, ClienteEntity cliente, MecanicoEntity mecanico, CarroEntity carro, Double valor, String problema, StatusEnum status) {
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

    public ManutencaoEntity() {
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

    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    public MecanicoEntity getMecanico() {
        return mecanico;
    }

    public void setMecanico(MecanicoEntity mecanico) {
        this.mecanico = mecanico;
    }

    public CarroEntity getCarro() {
        return carro;
    }

    public void setCarro(CarroEntity carro) {
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
