import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class ContaCorrente extends Conta implements Serializable {
    private float limiteChequeEspecial, taxaAdm;
    public static ArrayList<Clientes> arrayClientes = new ArrayList<Clientes>();

    public ContaCorrente(String senha, int numAgencia, int numeroConta, float saldoAtual, LocalDate dataAbertura, LocalDate dataUltimaMovimentacao, boolean status, float limiteChequeEspecial, float taxaAdm) {
        super(senha, numAgencia, numeroConta, saldoAtual, dataAbertura, dataUltimaMovimentacao, status);
        this.limiteChequeEspecial = limiteChequeEspecial;
        this.taxaAdm = taxaAdm;
    }

    public ContaCorrente(){super();}

    public float getLimiteChequeEspecial() {
        return limiteChequeEspecial;
    }

    public void setLimiteChequeEspecial(float limiteChequeEspecial) {
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    public float getTaxaAdm() {
        return taxaAdm;
    }

    public void setTaxaAdm(float taxaAdm) {
        this.taxaAdm = taxaAdm;
    }

    public void saque(float valor){
        if(saldoAtual < 0){
            throw new IllegalArgumentException("Saldo insuficiente.");
        } else if(valor < 0){
            throw new VerificaValorTransacaoException("Valor invalido para saque.");
        } else if(saldoAtual < valor){
            throw new IllegalArgumentException("Saldo insuficiente.");
        } else {
            saldoAtual -= valor;
            dataUltimaMovimentacao = LocalDate.now();
            Transacao transacao = new Transacao(dataUltimaMovimentacao, getNumeroConta(), valor, "internet banking");
            ArquivoTransacao.escreveTransacao(transacao);
            System.out.println("Saque realizado com sucesso!!");
        }
    }

    public void deposito(float valor){
        if(valor < 0){
            throw new VerificaValorTransacaoException("Valor invalido para deposito.");
        }
        super.deposito(valor);
    }

    public void pagamento(float valor){
        if(valor < 0){
            throw new VerificaValorTransacaoException("Valor invalido para pagamento.");
        } else if(saldoAtual+limiteChequeEspecial < valor){
            throw new IllegalArgumentException("Saldo insuficiente.");
        } else {
            saldoAtual -= valor;
            dataUltimaMovimentacao = LocalDate.now();
            Transacao transacao = new Transacao(dataUltimaMovimentacao, getNumeroConta(), valor, "internet banking");
            ArquivoTransacao.escreveTransacao(transacao);
            System.out.println("Conta paga com sucesso!!");
        }
    }

    public void consulta(){
        super.consulta();
    }
}
