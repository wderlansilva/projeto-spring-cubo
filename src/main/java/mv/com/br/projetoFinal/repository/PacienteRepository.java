package mv.com.br.projetoFinal.repository;

import mv.com.br.projetoFinal.model_entitys.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
