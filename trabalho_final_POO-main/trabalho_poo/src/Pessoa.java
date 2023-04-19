import java.io.Serializable;
import java.time.LocalDate;

public abstract class Pessoa implements Serializable {
    protected LocalDate dataNasc;
    protected String nome, endereco, estadoCivil, cpf;

    public Pessoa(LocalDate dataNasc, String nome, String endereco, String estadoCivil, String cpf) {
        this.dataNasc = dataNasc;
        this.nome = nome;
        this.endereco = endereco;
        this.estadoCivil = estadoCivil;
        this.cpf = cpf;
    }

    public Pessoa(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
    }

    public Pessoa(){}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    public abstract void mostraDados();
}
