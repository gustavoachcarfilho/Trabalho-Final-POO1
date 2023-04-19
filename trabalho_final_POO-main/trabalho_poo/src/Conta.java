import java.io.Serializable;
import java.time.LocalDate;

public abstract class Conta implements InterfaceTransacoes, Serializable {
    protected int numAgencia, numeroConta;
    protected float saldoAtual;
    protected LocalDate dataAbertura, dataUltimaMovimentacao;
    protected boolean status;
    protected String senha;

    public Conta(){};

    public Conta(String senha, int numAgencia, int numeroConta, float saldoAtual, LocalDate dataAbertura, LocalDate dataUltimaMovimentacao, boolean status) {
        this.senha = senha;
        this.numAgencia = numAgencia;
        this.numeroConta = numeroConta;
        this.saldoAtual = saldoAtual;
        this.dataAbertura = dataAbertura;
        this.dataUltimaMovimentacao = dataUltimaMovimentacao;
        this.status = status;
    }

    public void deposito(float valor){
        saldoAtual += valor;
        dataUltimaMovimentacao = LocalDate.now();
        Transacao transacao = new Transacao(dataUltimaMovimentacao, getNumeroConta(), valor, "caixa físico");
        ArquivoTransacao.escreveTransacao(transacao);
    }

    public void consulta(){
        System.out.println("=======================================");
        System.out.println("Numero Agencia: " + getNumAgencia());
        System.out.println("Numero conta: " + getNumeroConta());
        System.out.println("Saldo: R$" + getSaldoAtual());
        System.out.println("Data da ultima movimentação: " + getDataUltimaMovimentacao());
        System.out.println("=======================================");
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public float getSaldoAtual() {
        return saldoAtual;
    }

    public void setSaldoAtual(float saldoAtual) {
        this.saldoAtual = saldoAtual;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public LocalDate getDataUltimaMovimentacao() {
        return dataUltimaMovimentacao;
    }

    public void setDataUltimaMovimentacao(LocalDate dataUltimaMovimentacao) {
        this.dataUltimaMovimentacao = dataUltimaMovimentacao;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getNumAgencia() {
        return numAgencia;
    }

    public void setNumAgencia(int numAgencia) {
        this.numAgencia = numAgencia;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
