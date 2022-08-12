package projetoFinal.form;

import projetoFinal.model_entitys.Medico;
import projetoFinal.model_entitys.Paciente;
import projetoFinal.service.MedicoService;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class PacienteForm {

    @NotEmpty @NotNull @Length(min = 2)
    private String nome;
    @Digits(integer = 13, fraction = 0)
    private Long numero;
    @Digits(integer = 3, fraction = 0)
    private Long idade;
    @NotNull @NotEmpty @Length(min = 11, max = 11)
    private String cpf;
    @NotEmpty @NotNull @Length(min = 2)
    private String nomeMedico;

    public Paciente converte(MedicoService medicoService) {

        Medico medico = medicoService.findByNome(nomeMedico);

        return new Paciente(
                nome,
                numero,
                idade,
                cpf,
                medico
        );
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public String getNomeMedico() {
        return nomeMedico;
    }

    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }


}
