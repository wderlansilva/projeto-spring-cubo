package projetoFinal.model_entitys;

import javax.persistence.*;

@Entity
@Table(name = "Medico_mw")
public class Medico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(length = 100, nullable = false)
    public String nome;
    @Column(length = 100, nullable = false)
    public String hospital;
    @Column(length = 10, nullable = false)
    public Long crm;

    public Medico(){}

    public Medico(String nome, String hospital, Long crm) {
        this.nome = nome;
        this.hospital = hospital;
        this.crm = crm;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public Long getCrm() {
        return crm;
    }

    public void setCrm(Long crm) {
        this.crm = crm;
    }



}



