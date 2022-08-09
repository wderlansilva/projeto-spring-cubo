package mv.com.br.projetoFinal.controller;

import mv.com.br.projetoFinal.dto.PacienteDto;
import mv.com.br.projetoFinal.model_entitys.Medico;
import mv.com.br.projetoFinal.model_entitys.Paciente;
import mv.com.br.projetoFinal.service.PacienteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
public class Endpoint {

    PacienteService pacienteService;

    @GetMapping("/get")
    public String ola(){
        return "Olaa";
    }

    @RequestMapping("/")
    public List<PacienteDto> getPacientes(){
        return PacienteDto.converter(pacienteService.get());
    }

}
