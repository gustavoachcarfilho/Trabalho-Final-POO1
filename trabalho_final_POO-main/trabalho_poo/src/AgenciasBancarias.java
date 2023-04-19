public class AgenciasBancarias {
    protected int num_agencia;
    protected String nome_ficticio;
    protected String endereco;
    protected String cidade;
    protected String estado;
    protected String bairro;

    public AgenciasBancarias(int num_agencia, String nome_ficticio, String endereco, String cidade, String estado, String bairro) {
        this.num_agencia = num_agencia;
        this.nome_ficticio = nome_ficticio;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.bairro = bairro;
    }

    public int getNum_agencia() {
        return num_agencia;
    }

    public void setNum_agencia(int num_agencia) {
        this.num_agencia = num_agencia;
    }

    public String getNome_ficticio() {
        return nome_ficticio;
    }

    public void setNome_ficticio(String nome_ficticio) {
        this.nome_ficticio = nome_ficticio;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
}
