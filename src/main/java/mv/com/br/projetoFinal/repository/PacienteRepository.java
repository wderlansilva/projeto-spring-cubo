package mv.com.br.projetoFinal.repository;

import mv.com.br.projetoFinal.model_entitys.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    List<Paciente> findByNome(String nome);

    List<Paciente> findByMedico_Nome(String nomeMedico);
}
