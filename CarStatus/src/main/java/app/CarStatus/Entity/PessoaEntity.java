package app.CarStatus.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class PessoaEntity implements Serializable {
    @Id
    @GeneratedValue( strategy = GenerationType.TABLE )
    @Column( columnDefinition = "Long")
    private Long id;

    @Column( nullable = false )
    private String nome;

    @Column( nullable = false )
    private String cpf;

    @Column( nullable = false )
    private String telefone;

    public PessoaEntity() {
    }

    public PessoaEntity(Long id, String nome, String cpf, String telefone) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) { this.telefone = telefone; }
}
