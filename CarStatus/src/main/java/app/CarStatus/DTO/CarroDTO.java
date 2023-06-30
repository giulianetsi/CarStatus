package app.CarStatus.DTO;

public class CarroDTO {
    private Long id;
    private String placa;
    private String marca;
    private String modelo;
    private ClienteDTO dono;

    public CarroDTO(Long id, String placa, String marca, String modelo, ClienteDTO dono) {
        this.id = id;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.dono = dono;
    }

    public CarroDTO() {
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

    public ClienteDTO getDono() {
        return dono;
    }

    public void setDono(ClienteDTO dono) {
        this.dono = dono;
    }
}
