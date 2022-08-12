package projetoFinal.repository;

import projetoFinal.model_entitys.Paciente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    Page<Paciente> findByNome(String nome, Pageable pageable);

    Page<Paciente> findByMedico_Nome(String nomeMedico);

    Optional<Paciente> findByCpf(String cpf);
}
