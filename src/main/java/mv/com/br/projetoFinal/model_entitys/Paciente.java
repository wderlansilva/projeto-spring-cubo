package mv.com.br.projetoFinal.model_entitys;

public class Paciente {

    private Long id;
    private String nome;
    private Long numero;
    private Long idade;
    private Medico medico;

    public Paciente(){

    }

    public Paciente(Long id, String nome, Long numero, Long idade, Medico medico) {
        this.id = id;
        this.nome = nome;
        this.numero = numero;
        this.idade = idade;
        this.medico = medico;
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

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public Long getIdade() {
        return idade;
    }

    public void setIdade(Long idade) {
        this.idade = idade;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
}
