package mv.com.br.projetoFinal.form;

import mv.com.br.projetoFinal.model_entitys.Medico;
import mv.com.br.projetoFinal.model_entitys.Paciente;
import mv.com.br.projetoFinal.service.MedicoService;
import org.springframework.http.ResponseEntity;

import javax.persistence.Column;
import javax.persistence.ManyToOne;

public class PacienteForm {

    private String nome;
    private Long numero;
    private Long idade;
    private String nomeMedico;

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

    public static Paciente converte(PacienteForm pacienteForm, MedicoService medicoService) {

        Medico medico = medicoService.getMedicoByNome(pacienteForm.getNomeMedico());

        return new Paciente(
                pacienteForm.getNome(),
                pacienteForm.getNumero(),
                pacienteForm.getIdade(),
                medico
        );
    }
}
