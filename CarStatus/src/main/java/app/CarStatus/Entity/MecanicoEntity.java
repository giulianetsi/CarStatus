package app.CarStatus.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class MecanicoEntity extends PessoaEntity{

    @Column(nullable = false)
    private Double precoHora;

    @OneToMany(mappedBy = "mecanico")
    private List<ManutencaoEntity> manutencoes;

    public MecanicoEntity(Long id, String nome, String cpf, String telefone, Double precoHora, List<ManutencaoEntity> manutencoes) {
        super(id, nome, cpf, telefone);
        this.precoHora = precoHora;
        this.manutencoes = manutencoes;
    }

    public MecanicoEntity() {
    }

    public Double getPrecoHora() {
        return precoHora;
    }

    public void setPrecoHora(Double precoHora) {
        this.precoHora = precoHora;
    }

    public List<ManutencaoEntity> getManutencoes() {
        return manutencoes;
    }

    public void setManutencoes(List<ManutencaoEntity> manutencoes) {
        this.manutencoes = manutencoes;
    }
}
