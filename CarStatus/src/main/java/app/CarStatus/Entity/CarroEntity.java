package app.CarStatus.Entity;

import javax.persistence.*;

@Entity
public class CarroEntity {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( columnDefinition = "Long")
    private Long id;

    @Column( nullable = false )
    private String placa;

    @Column( nullable = false )
    private String marca;

    @Column( nullable = false )
    private String modelo;

    @ManyToOne( fetch = FetchType.LAZY )
    @JoinColumn( name = "id_dono" )
    private ClienteEntity dono;

    public CarroEntity() {
    }

    public CarroEntity(Long id, String placa, String marca, String modelo, ClienteEntity dono) {
        this.id = id;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.dono = dono;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public ClienteEntity getDono() {
        return dono;
    }

    public void setDono(ClienteEntity dono) {
        this.dono = dono;
    }
}