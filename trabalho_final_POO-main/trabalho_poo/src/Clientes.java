import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Clientes extends Pessoa implements Serializable {
    protected String escolaridade;
    protected int agencia, num_conta;
    ArrayList<Conta> arrayContas = new ArrayList<Conta>();

    public Clientes(LocalDate dataNasc, String nome, String endereco, String estadoCivil, String cpf, String escolaridade, Conta conta) {
        super(dataNasc, nome, endereco, estadoCivil, cpf);
        this.escolaridade = escolaridade;
        this.agencia = conta.getNumAgencia();
        this.num_conta = conta.getNumeroConta();
        arrayContas.add(conta);
    }

    public Clientes(String nome, String cpf){
        super(nome, cpf);
    }

    public Clientes(){
        super();
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getNum_conta() {
        return num_conta;
    }

    public void setNum_conta(int num_conta) {
        this.num_conta = num_conta;
    }

    public void mostraDados() {
        int cont;

        System.out.println("========================");
        System.out.println("CPF:" + getCpf());
        System.out.println("Nome:" + getNome());
        for(cont = 0; cont < arrayContas.size(); cont++){
            System.out.println("Agencia:" + arrayContas.get(cont).getNumAgencia());
            System.out.println("Numero da conta:" + arrayContas.get(cont).getNumeroConta());
            System.out.println("Data da ultima movimentacao:" + arrayContas.get(cont).getDataUltimaMovimentacao());
        }
        System.out.println("========================");
    }

}
