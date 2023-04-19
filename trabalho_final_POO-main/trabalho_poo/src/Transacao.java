import java.io.Serializable;
import java.time.LocalDate;

public class Transacao implements Serializable {
    private int numeroConta;
    private float valor;
    private String canal;
    private LocalDate data;

    public Transacao(LocalDate data, int numeroConta, float valor, String canal){
        this.data = data;
        this.numeroConta = numeroConta;
        this.valor = valor;
        this.canal = canal;
    }

    public Transacao(){};

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getCanal() {
        return canal;
    }

    public void setCanal(String canal) {
        this.canal = canal;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void mostraDados(){
        System.out.println("Numero da Conta: " + getNumeroConta() + "\nValor: " + getValor() + "\nCanal: " + getCanal() + "\nData: " + getData());
    }
}
