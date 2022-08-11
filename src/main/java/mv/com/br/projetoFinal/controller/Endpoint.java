package mv.com.br.projetoFinal.controller;

import com.sun.org.apache.xpath.internal.objects.XObject;
import mv.com.br.projetoFinal.dto.PacienteDto;
import mv.com.br.projetoFinal.form.PacienteForm;
import mv.com.br.projetoFinal.model_entitys.Medico;
import mv.com.br.projetoFinal.model_entitys.Paciente;
import mv.com.br.projetoFinal.service.MedicoService;
import mv.com.br.projetoFinal.service.PacienteService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public List<PacienteDto> getPacientebyNome(String nome){

        if(nome != null){
            return PacienteDto.converter(pacienteService.searchPacienteByNome(nome));
        }
        return PacienteDto.converter(pacienteService.get());

    }

    @GetMapping("/filter/medico")
    public List<PacienteDto> getMedicoByNome(String nomeMedico){

        if(nomeMedico != null){
            return PacienteDto.converter(pacienteService.searchMedicoByNome(nomeMedico));
        }
        return PacienteDto.converter(pacienteService.get());

    }

    @PostMapping
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
