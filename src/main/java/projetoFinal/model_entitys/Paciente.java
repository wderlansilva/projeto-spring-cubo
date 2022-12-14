package projetoFinal.model_entitys;

import javax.persistence.*;

@Entity
@Table(name = "Pacientes_mw")
public class Paciente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String nome;
    @Column(length = 20)
    private Long numero;
    @Column(length = 3, nullable = false)
    private Long idade;

    @Column(length = 20, nullable = false)
    private String cpf;
    @ManyToOne
    private Medico medico;

    public Paciente(){

    }

    public Paciente(String nome, Long numero, Long idade, String cpf, Medico medico) {
        this.nome = nome;
        this.numero = numero;
        this.idade = idade;
        this.cpf = cpf;
        this.medico = medico;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public Long getIdade() {
        return idade;
    }

    public void setIdade(Long idade) {
        this.idade = idade;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
}
