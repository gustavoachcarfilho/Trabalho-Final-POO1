import java.io.Serializable;
import java.time.LocalDate;
public class ContaSalario extends Conta implements Serializable {
    private float limiteSaque, limiteTransferencia;

    public ContaSalario(String senha, int numAgencia, int numeroConta, float saldoAtual, LocalDate dataAbertura, LocalDate dataUltimaMovimentacao, boolean status, float limiteSaque, float limiteTransferencia) {
        super(senha, numAgencia, numeroConta, saldoAtual, dataAbertura, dataUltimaMovimentacao, status);
        this.limiteSaque = limiteSaque;
        this.limiteTransferencia = limiteTransferencia;
    }

    public ContaSalario(){super();}

    public float getLimiteSaque() {
        return limiteSaque;
    }

    public void setLimiteSaque(float limiteSaque) {
        this.limiteSaque = limiteSaque;
    }

    public float getLimiteTransferencia() {
        return limiteTransferencia;
    }

    public void setLimiteTransferencia(float limiteTransferencia) {
        this.limiteTransferencia = limiteTransferencia;
    }

    public void saque(float valor){
        if(valor < 0){
            throw new VerificaValorTransacaoException("Valor invalido para saque.");
        } else if(valor > limiteSaque){
            throw new IllegalArgumentException("Valor acima do limite de saque.");
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
