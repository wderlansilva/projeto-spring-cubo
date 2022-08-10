package mv.com.br.projetoFinal.repository;

import mv.com.br.projetoFinal.model_entitys.Medico;
import mv.com.br.projetoFinal.model_entitys.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {

    Medico findByNome(String nome);
}
