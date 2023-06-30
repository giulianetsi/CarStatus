package app.CarStatus.DTO;

import java.util.List;

public class ClienteDTO extends PessoaDTO {
    List<CarroDTO> carros;

    public ClienteDTO() {
    }

    public ClienteDTO(Long id, String nome, String cpf, String telefone, List<CarroDTO> carros) {
        super(id, nome, cpf, telefone);
        this.carros = carros;
    }

    public List<CarroDTO> getCarros() {
        return carros;
    }

    public void setCarros(List<CarroDTO> carros) {
        this.carros = carros;
    }
}
