package projetoFinal.dto;

import projetoFinal.model_entitys.Medico;

public class MedicoDto {
    private String nome;
    private String hospital;
    private Long crm;

    public MedicoDto(Medico medico) {
        this.nome = medico.getNome();
        this.hospital = medico.getHospital();
        this.crm = medico.getCrm();
    }

    public String getNome() {
        return nome;
    }

    public String getHospital() {
        return hospital;
    }
    public Long getCrm() {
        return crm;
    }
}
