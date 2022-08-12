package projetoFinal.dto;

import projetoFinal.model_entitys.Medico;
import projetoFinal.model_entitys.Paciente;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PacienteDto {
    private String nome;
    private Long numero;
    private Long idade;
    private Medico medico;

    public PacienteDto(Paciente paciente){
        this.nome = paciente.getNome();
        this.numero = paciente.getNumero();
        this.idade = paciente.getIdade();
        this.medico = paciente.getMedico();
    }

    public static Page<PacienteDto> converter(Page<Paciente> listaPaciente) {

        return listaPaciente.map(PacienteDto::new);
    }

    public String getNome() {
        return nome;
    }

    public Long getNumero() {
        return numero;
    }

    public Long getIdade() {
        return idade;
    }

    public Medico getMedico() {
        return medico;
    }
}
