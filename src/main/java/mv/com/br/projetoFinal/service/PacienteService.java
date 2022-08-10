package mv.com.br.projetoFinal.service;

import mv.com.br.projetoFinal.model_entitys.Paciente;
import mv.com.br.projetoFinal.repository.MedicoRepository;
import mv.com.br.projetoFinal.repository.PacienteRepository;
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

    public List<Paciente> get(){
       return  pacienteRepository.findAll();
    }


    public List<Paciente> searchPacienteByNome(String nome) {
        return pacienteRepository.findByNome(nome);
    }

    public List<Paciente> searchMedicoByNome(String nomeMedico) {
        return pacienteRepository.findByMedico_Nome(nomeMedico);
    }

    public Paciente savePaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }
}
