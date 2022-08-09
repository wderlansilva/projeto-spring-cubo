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

        


        Paciente paciente1 = new Paciente(
                1L, "Wderlan", 123123L, 123L, new Medico(
                        "Marcos","Portugues", 1239L) );

        Paciente paciente2 = new Paciente(
                1L, "Jose", 123123L, 123L, new Medico(
                        "Lucas","Portugues", 1239L) );

        return PacienteDto.converter(Arrays.asList(paciente1, paciente2));
    }

}
