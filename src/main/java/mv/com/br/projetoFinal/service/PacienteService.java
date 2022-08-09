package mv.com.br.projetoFinal.service;

import mv.com.br.projetoFinal.model_entitys.Paciente;
import mv.com.br.projetoFinal.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class PacienteService  {

    @Autowired
    PacienteRepository pacienteRepository;

}
