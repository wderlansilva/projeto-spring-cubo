package mv.com.br.projetoFinal.service;

import mv.com.br.projetoFinal.model_entitys.Medico;
import mv.com.br.projetoFinal.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MedicoService {

    @Autowired
    MedicoRepository medicoRepository;

    public Medico findByNome(String nomeMedico){
        return medicoRepository.findByNome(nomeMedico);
    }


    public Optional<Medico> findByNomeOptional(String nomeMedico) {
        return Optional.ofNullable(medicoRepository.findByNome(nomeMedico));
    }
}
