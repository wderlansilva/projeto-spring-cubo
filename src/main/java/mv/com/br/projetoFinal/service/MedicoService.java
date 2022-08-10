package mv.com.br.projetoFinal.service;

import mv.com.br.projetoFinal.model_entitys.Medico;
import mv.com.br.projetoFinal.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicoService {

    @Autowired
    MedicoRepository medicoRepository;


    public Medico getMedicoByNome(String nome) {
        return medicoRepository.findByNome(nome);
    }
}
