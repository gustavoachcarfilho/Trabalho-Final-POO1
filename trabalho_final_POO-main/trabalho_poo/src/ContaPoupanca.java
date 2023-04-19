import java.io.Serializable;
import java.time.LocalDate;

public class ContaPoupanca extends Conta implements Serializable {
    private float rendimentoMes;

    public ContaPoupanca(String senha, int numAgencia, int numeroConta, float saldoAtual, LocalDate dataAbertura, LocalDate dataUltimaMovimentacao, boolean status, float rendimentoMes) {
        super(senha, numAgencia, numeroConta, saldoAtual, dataAbertura, dataUltimaMovimentacao, status);
        this.rendimentoMes = rendimentoMes;
    }

    public ContaPoupanca(){super();}

    public float getRendimentoMes() {
        return rendimentoMes;
    }

    public void setRendimentoMes(float rendimentoMes) {
        this.rendimentoMes = rendimentoMes;
    }

    public void saque(float valor){
        if(valor < 0){
            throw new VerificaValorTransacaoException("Valor invalido para saque.");
        } else if(saldoAtual < valor){
            throw new IllegalArgumentException("Saldo insuficiente.");
        } else {
            saldoAtual -= valor;
            dataUltimaMovimentacao = LocalDate.now();
            Transacao transacao = new Transacao(dataUltimaMovimentacao, getNumeroConta(), valor, "internet banking");
            ArquivoTransacao.escreveTransacao(transacao);
            System.out.println("Conta paga com sucesso!!");
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
        } else if(saldoAtual < valor){
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
