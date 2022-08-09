package mv.com.br.projetoFinal.model_entitys;

public class Medico {
    public Long id;
    public String nome;
    public String hospital;
    public Long crm;

    public Medico(Long id, String nome, String hospital, Long crm) {
        this.id = id;
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



