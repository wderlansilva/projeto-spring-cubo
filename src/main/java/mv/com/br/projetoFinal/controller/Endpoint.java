package mv.com.br.projetoFinal.controller;

import com.sun.org.apache.xpath.internal.objects.XObject;
import mv.com.br.projetoFinal.dto.PacienteDto;
import mv.com.br.projetoFinal.form.PacienteForm;
import mv.com.br.projetoFinal.model_entitys.Medico;
import mv.com.br.projetoFinal.model_entitys.Paciente;
import mv.com.br.projetoFinal.service.MedicoService;
import mv.com.br.projetoFinal.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

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
    public ResponseEntity<Object> postPaciente(@RequestBody PacienteForm pacienteForm){
        Paciente paciente = pacienteForm.converte(pacienteForm,medicoService);

        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteService.savePaciente(paciente));
    }




}
