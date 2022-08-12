package projetoFinal.controller;

import com.sun.org.apache.xpath.internal.objects.XObject;
import projetoFinal.dto.PacienteDto;
import projetoFinal.form.PacienteForm;
import projetoFinal.model_entitys.Medico;
import projetoFinal.model_entitys.Paciente;
import projetoFinal.service.MedicoService;
import projetoFinal.service.PacienteService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pacientes")
public class Endpoint {

    @Autowired
    PacienteService pacienteService;

    @Autowired
    MedicoService medicoService;

    @GetMapping
    @Cacheable(value = "ListaPacientes")
    public Page<PacienteDto> getPacientebyNome(String nome, @PageableDefault(page = 0,size = 2,sort = "nome", direction = Sort.Direction.DESC) Pageable pageable){

        if(nome != null){
            return PacienteDto.converter(pacienteService.searchPacienteByNome(nome, pageable));
        }
        return PacienteDto.converter(pacienteService.get(pageable));

    }

    @GetMapping("/filter/medico")
    public Page<PacienteDto> getMedicoByNome(String nomeMedico, @PageableDefault(page = 0,size = 2,sort = "nome", direction = Sort.Direction.DESC) Pageable pageable){

        if(nomeMedico != null){
            return PacienteDto.converter(pacienteService.searchMedicoByNome(nomeMedico));
        }
        return PacienteDto.converter(pacienteService.get(pageable));

    }

    @PostMapping
    @CacheEvict(value = "ListaPacientes", allEntries = true)
    @Transactional
    public ResponseEntity<Object> postPaciente(@RequestBody @Valid PacienteForm pacienteForm){

        Optional<Medico> optionalMedico = medicoService.findByNomeOptional(pacienteForm.getNomeMedico());

        if(!optionalMedico.isPresent()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Esse medico não está cadastrado no sistema, não foi possível cadastrar o paciente.");
        }

        Optional<Paciente> pacienteOptional = pacienteService.getPaciente(pacienteForm.getCpf());

        if(!pacienteOptional.isPresent()){
            Paciente paciente = pacienteForm.converte(medicoService);
            return ResponseEntity.status(HttpStatus.CREATED).body(pacienteService.savePaciente(paciente));
        } else if(!(pacienteOptional.get().getMedico().getNome().equalsIgnoreCase(pacienteForm.getNomeMedico()))){
            Paciente paciente = pacienteForm.converte(medicoService);
            return ResponseEntity.status(HttpStatus.CREATED).body(pacienteService.savePaciente(paciente));
        }

        return ResponseEntity.status(HttpStatus.CONFLICT).body("Paciente já cadastrado/O medico não existe");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePaciente(@PathVariable Long id){

        Optional<Paciente> optionalPaciente = pacienteService.getPacienteById(id);

        if(optionalPaciente.isPresent()){
            pacienteService.deletePaciente(id);
            return ResponseEntity.status(HttpStatus.OK).body("Paciente removido com sucesso!");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Esse paciente não existe!");
    }

    @PutMapping("/{id}")
    @CacheEvict(value = "ListaPacientes", allEntries = true)
    @Transactional
    public ResponseEntity<Object> putPaciente(@PathVariable Long id, @RequestBody @Valid PacienteForm pacienteForm) {

        Optional<Paciente> optionalPaciente = pacienteService.getPacienteById(id);

        if (!optionalPaciente.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Esse paciente não existe!");
        }

        Paciente paciente = new Paciente();
        BeanUtils.copyProperties(pacienteForm,paciente);

        paciente.setId(optionalPaciente.get().getId());
        paciente.setMedico(optionalPaciente.get().getMedico());

        return ResponseEntity.status(HttpStatus.OK).body(pacienteService.savePaciente(paciente));
    }



}
