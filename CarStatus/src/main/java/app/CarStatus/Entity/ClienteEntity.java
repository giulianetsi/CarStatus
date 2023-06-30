package app.CarStatus.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class ClienteEntity extends PessoaEntity{

    @OneToMany( mappedBy = "dono")
    private List<CarroEntity> carros;

    @OneToMany( mappedBy = "cliente")
    private List<ManutencaoEntity> manutencoes;

    public ClienteEntity() {
    }

    public ClienteEntity(Long id, String nome, String cpf, String telefone, List<CarroEntity> carros, List<ManutencaoEntity> manutencoes) {
        super(id, nome, cpf, telefone);
        this.carros = carros;
        this.manutencoes = manutencoes;
    }

    public List<CarroEntity> getCarros() {
        return carros;
    }

    public void setCarros(List<CarroEntity> carros) {
        this.carros = carros;
    }

    public List<ManutencaoEntity> getManutencoes() {
        return manutencoes;
    }

    public void setManutencoes(List<ManutencaoEntity> manutencoes) {
        this.manutencoes = manutencoes;
    }
}