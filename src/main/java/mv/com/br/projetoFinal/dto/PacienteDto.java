package mv.com.br.projetoFinal.dto;

import mv.com.br.projetoFinal.model_entitys.Medico;
import mv.com.br.projetoFinal.model_entitys.Paciente;

import java.util.ArrayList;
import java.util.List;

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

    public static List<PacienteDto> converter(List<Paciente> listaPaciente) {

        List<PacienteDto> listaPacienteDto = new ArrayList<>();

        for(int i = 0; i < listaPaciente.size(); i++){

            PacienteDto pacienteDto = new PacienteDto(listaPaciente.get(i));

            listaPacienteDto.add(pacienteDto);
        }

        return listaPacienteDto;
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
