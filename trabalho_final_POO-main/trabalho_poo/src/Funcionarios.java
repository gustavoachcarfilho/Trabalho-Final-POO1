import java.time.LocalDate;
import java.time.Period;
public class Funcionarios extends Pessoa{
    protected String nro_carteita_trab;
    protected String RG;
    protected String sexo;
    protected String cargo;
    protected float salario;
    protected LocalDate ano_ingresso;

    public Funcionarios(LocalDate dataNasc, String nome, String endereco, String estadoCivil, String cpf, String nro_carteita_trab, String RG, String sexo, String cargo, float salario, LocalDate ano_ingresso) {
        super(dataNasc, nome, endereco, estadoCivil, cpf);
        this.nro_carteita_trab = nro_carteita_trab;
        this.RG = RG;
        this.sexo = sexo;
        this.cargo = cargo;
        this.salario = salario;
        this.ano_ingresso = ano_ingresso;
    }

    public Funcionarios(LocalDate dataNasc, String nome, String endereco, String estadoCivil, String cpf, String nro_carteita_trab, String RG, String sexo, float salario, LocalDate ano_ingresso) {
        super(dataNasc, nome, endereco, estadoCivil, cpf);
        this.nro_carteita_trab = nro_carteita_trab;
        this.RG = RG;
        this.sexo = sexo;
        this.salario = salario;
        this.ano_ingresso = ano_ingresso;
        this.cargo = "Gerente";
    }

    public Funcionarios(LocalDate ano_ingresso, float salario){
        this.salario = salario;
        this.ano_ingresso = ano_ingresso;
    }

    public float calculaSalario(){
        Period data;

        data = Period.between(getAno_ingresso(),LocalDate.now());

        if(data.getYears() >= 15){
            return (float) ((float) getSalario() + (0.1 * getSalario()));
        } else {
            return getSalario();
        }
    }

    public String getNro_carteita_trab() {
        return nro_carteita_trab;
    }

    public void setNro_carteita_trab(String nro_carteita_trab) {
        this.nro_carteita_trab = nro_carteita_trab;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public LocalDate getAno_ingresso() {
        return ano_ingresso;
    }

    public void setAno_ingresso(LocalDate ano_ingresso) {
        this.ano_ingresso = ano_ingresso;
    }

    public void mostraDados(){
        System.out.println("Nome:" + getNome());
        System.out.println("CPF:" + getCpf());
        System.out.println("RG:" + getRG());
        System.out.println("Cargo:" + getCargo());
        System.out.println("Ano de ingresso:" + getAno_ingresso());
    }
}
