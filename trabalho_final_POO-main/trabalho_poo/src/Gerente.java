import java.time.LocalDate;
public class Gerente extends Funcionarios{
    protected LocalDate data_ingresso;
    protected int num_agencia;
    protected boolean possui_curso;

    private static float comissao;

    public Gerente(LocalDate dataNasc, String nome, String endereco, String estadoCivil, String cpf, String nro_carteita_trab, String RG, String sexo, float salario, float comissao, LocalDate ano_ingresso, LocalDate data_ingresso, int num_agencia, boolean possui_curso) {
        super(dataNasc, nome, endereco, estadoCivil, cpf, nro_carteita_trab, RG, sexo, salario, ano_ingresso);
        this.data_ingresso = data_ingresso;
        this.num_agencia = num_agencia;
        this.possui_curso = possui_curso;
        setComissao(comissao);
    }

    public float calculaSalario(){
        return this.salario + getComissao();
    }

    public static float getComissao() {
        return comissao;
    }

    public static void setComissao(float comissao) {
        Gerente.comissao = comissao;
    }

    public LocalDate getData_ingresso() {
        return data_ingresso;
    }

    public void setData_ingresso(LocalDate data_ingresso) {
        this.data_ingresso = data_ingresso;
    }

    public int getNum_agencia() {
        return num_agencia;
    }

    public void setNum_agencia(int num_agencia) {
        this.num_agencia = num_agencia;
    }

    public boolean isPossui_curso() {
        return possui_curso;
    }

    public void setPossui_curso(boolean possui_curso) {
        this.possui_curso = possui_curso;
    }

    public void mostraDados(){
        super.mostraDados();
        System.out.println("Numero da agencia:" + getNum_agencia());
    }
}
