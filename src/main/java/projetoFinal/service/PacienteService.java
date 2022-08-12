package projetoFinal.service;

import projetoFinal.model_entitys.Paciente;
import projetoFinal.repository.MedicoRepository;
import projetoFinal.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class PacienteService  {
    @Autowired
    PacienteRepository pacienteRepository;

    @Autowired
    MedicoRepository medicoRepository;

    public Page<Paciente> get(Pageable pageable){
       return  pacienteRepository.findAll(pageable);
    }


    public Page<Paciente> searchPacienteByNome(String nome, Pageable pageable) {
        return pacienteRepository.findByNome(nome,pageable);
    }

    public Page<Paciente> searchMedicoByNome(String nomeMedico) {
        return pacienteRepository.findByMedico_Nome(nomeMedico);
    }

    public Paciente savePaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public Optional<Paciente> getPaciente(String cpf) {
        return pacienteRepository.findByCpf(cpf);
    }

    public Optional<Paciente> getPacienteById(Long id) {
        return pacienteRepository.findById(id);
    }

    public void deletePaciente(Long id) {
        pacienteRepository.deleteById(id);
    }
}
