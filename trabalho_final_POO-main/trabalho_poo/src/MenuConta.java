import java.io.Serializable;
import java.security.InvalidParameterException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
public class MenuConta implements Serializable {
    private static Scanner input = new Scanner(System.in);
    private static ArrayList<Clientes> arrayClientes = new ArrayList<>();
    private static Conta conta;
    private static Clientes cliente;
    public static AgenciasBancarias agencia = new AgenciasBancarias(1903, "Agencia Uberlandia", "rua dois nº123, bairro tres", "Uberlandia", "Minas Gerais", "bairro tres");
    private static Gerente gerente = new Gerente(LocalDate.parse("1998-10-07"), "Jose da Silva", "rua tres nº456, bairro vinte", "casado", "90476762030", "23178917078", "13.852.346-0", "masculino", 10000f, 500f, LocalDate.parse("2020-06-09"), LocalDate.parse("2020-06-09"), 1903, true);


    public static void lerArquivoCliente(){
        arrayClientes = ArquivoClientes.leituraArquivoClientes();
    }

    public static void escreveArquivoCliente(){
        ArquivoClientes.escreveArquivoClientes();
    }

    public static void entrarConta(){
        String cpf;
        int numConta = 0, pos = 0, s = 0;
        System.out.print("Digite seu CPF (sem pontuacao): ");
        cpf = input.next();

        try{
            ValidaCPF.isCPF(cpf);
            try {
                pos = ArrayListFuncoes.mostraContasPorCPF(arrayClientes, cpf);
                System.out.print("Digite o número da conta em que deseja entrar: ");
                numConta = input.nextInt();
                try {
                    conta = ArrayListFuncoes.buscaContasPorNumero(arrayClientes, pos, numConta);
                    while (s != 1){
                        try{
                            s = confereSenha();
                        }
                        catch (IllegalArgumentException erro){
                            System.out.println(erro.getMessage());
                        }
                    }
                    MenuTransacoes.menu(conta);
                } catch (InvalidParameterException erro){
                    System.out.println(erro.getMessage());
                }
            } catch (InvalidParameterException erro){
                System.out.println(erro.getMessage());
            }
        } catch (IllegalArgumentException erro){
            System.out.println(erro.getMessage());
        }
    }

    public static void cadastrarConta(){
        int opcao = 0, aux;
        Clientes cliente2;

        while(opcao < 1 || opcao > 2) {
            System.out.println("Ja possui uma conta ?");
            System.out.println("[1] Sim");
            System.out.println("[2] Nao");
            opcao = input.nextInt();

            switch (opcao) {
                case (1):
                    String cpf;
                    System.out.print("Digite seu CPF (sem pontuacao): ");
                    cpf = input.next();

                    try {
                        ValidaCPF.isCPF(cpf);
                        try{
                            cliente2 = ArrayListFuncoes.buscaContaPorCPF(arrayClientes, cpf);
                            try{
                                conta = cadastraConta();
                                try {
                                    ArrayListFuncoes.adicionaConta(cliente2, conta);
                                    System.out.println("Conta criada com sucesso!!");
                                } catch (NullPointerException erro){
                                    System.out.println(erro.getMessage());
                                }
                            } catch (IllegalArgumentException erro){
                                System.out.println(erro.getMessage());
                            }
                        } catch (IllegalArgumentException erro){
                            System.out.println(erro.getMessage());
                        }
                    } catch (IllegalArgumentException erro){
                        System.out.println(erro.getMessage());
                    }
                    return;
                case (2):
                    aux = cadastraClientes();
                    if(aux == -1) {
                        return;
                    } else {
                        System.out.println("Conta cadastrada com sucesso!!");
                    }
                    break;
                default:
                    System.out.println("Número inválido, digite o número de uma das opções.");
            }
        }
    }

    public static int cadastraClientes(){
        String nome, endereco, estadoCivil, escolaridade, dataNasc, cpf;
        Conta conta;

        System.out.println("=============================================");
        System.out.println("Para começar, digite seus dados.");
        input.nextLine(); // limpando o buffer
        System.out.print("Nome: ");
        nome = input.nextLine();
        input.nextLine(); // limpando o buffer
        System.out.print("CPF: ");
        cpf = input.nextLine();
        try{
            ValidaCPF.isCPF(cpf);
        } catch (IllegalArgumentException erro){
            System.out.println(erro.getMessage());
            return -1;
        }
        input.nextLine(); // limpando o buffer
        System.out.print("Data de nascimento (yyyy-mm-dd): ");
        dataNasc = input.nextLine();
        input.nextLine(); // limpando o buffer
        System.out.print("Endereco: ");
        endereco = input.nextLine();
        input.nextLine(); // limpando o buffer
        System.out.print("Estado civil: ");
        estadoCivil = input.nextLine();
        input.nextLine(); // limpando o buffer
        System.out.print("Escolaridade: ");
        escolaridade = input.nextLine();
        input.nextLine(); // limpando o buffer
        System.out.println("=============================================");

        conta = cadastraConta();
        if(conta == null)
            return -1;
        else {
            try {
                cliente = ArrayListFuncoes.buscaContaPorCPF(arrayClientes, cpf);
                cliente.arrayContas.add(conta);
            } catch (IllegalArgumentException erro) {
                cliente = new Clientes(LocalDate.parse(dataNasc), nome, endereco, estadoCivil, cpf, escolaridade, conta);
                arrayClientes.add(cliente);
            }
            return 0;
        }
    }

    public static Conta cadastraConta(){
        int opcao = 0, numConta = 0;
        Conta conta = null;
        String cpf, senha;
        Random aleatorio = new Random();


        while(opcao < 1 || opcao > 4) {
            System.out.println("=============================================");
            System.out.println("Qual tipo de conta deseja criar? ");
            System.out.println("[1] Conta Corrente");
            System.out.println("[2] Conta Salario");
            System.out.println("[3] Conta Poupança");
            System.out.println("[4] Conta Conjunta");
            System.out.println("=============================================");
            opcao = input.nextInt();

            numConta = aleatorio.nextInt(10000);

            switch (opcao) {
                case (1):
                    senha = forneceSenha(agencia.getNum_agencia(), numConta);
                    conta = new ContaCorrente(senha, agencia.getNum_agencia(), numConta, 0f, LocalDate.now(), null, true, 200f, 15f);
                    break;
                case (2):
                    senha = forneceSenha(agencia.getNum_agencia(), numConta);
                    conta = new ContaSalario(senha, agencia.getNum_agencia(), numConta, 0f, LocalDate.now(), null, true, 300f, 1000f);
                    break;
                case (3):
                    senha = forneceSenha(agencia.getNum_agencia(), numConta);
                    conta = new ContaPoupanca(senha, agencia.getNum_agencia(), numConta, 0f, LocalDate.now(), null, true, 0.1f);
                    break;
                case (4):
                    senha = forneceSenha(agencia.getNum_agencia(), numConta);
                    System.out.print("Digite o CPF do segundo membro da conta: ");
                    cpf = input.next();
                    try {
                        ValidaCPF.isCPF(cpf);
                        try {
                            cliente = ArrayListFuncoes.buscaContaPorCPF(arrayClientes, cpf);
                            conta = new ContaCorrente(senha, agencia.getNum_agencia(), numConta, 0f, LocalDate.now(), null, true, 200f, 15f);
                            cliente.arrayContas.add(conta);
                        } catch (IllegalArgumentException erro){
                            System.out.println("Não é possível criar uma conjunta, os dois integrantes precisam ser cadastrados.");
                            return null;
                        }
                    } catch (IllegalArgumentException erro){
                        System.out.println(erro.getMessage());
                        return null;
                    }
                    break;
                default:
                    System.out.println("Número inválido, digite o número de uma das opções.");
            }
        }
        return conta;
    }

    public static void desativarConta(){
        String cpf;
        int numConta, pos;
        System.out.print("Digite seu CPF (sem pontuacao): ");
        cpf = input.next(); // pega o CPF do cliente

        try{
            ValidaCPF.isCPF(cpf); // tenta validar o CPF
            try{
                pos = ArrayListFuncoes.mostraContasPorCPF(arrayClientes, cpf); // verifica se o CPF digitado possui alguma conta
                System.out.print("Digite o número da conta que deseja desativar: ");
                numConta = input.nextInt(); // pega o número da conta que o cliente deseja desativar
                try{
                    ArrayListFuncoes.desativarContasPorNumero(arrayClientes, pos, numConta); // tenta desativar a conta
                    System.out.println("Conta desativada com sucesso!!");
                } catch (IllegalArgumentException erro){
                    System.out.println(erro.getMessage()); // se o número digitado pelo cliente estiver errado, volta uma mensagem de erro
                }
            } catch (IllegalArgumentException erro){
                System.out.println(erro.getMessage()); // se o cliente não possuir nenhuma conta, volta uma mensagem de erro
            }
        } catch (IllegalArgumentException erro){
            System.out.println(erro.getMessage()); // se o CPF digitado não for válido, volta uma mensagem de erro
        }
    }

    private static String forneceSenha(int agencia, int numConta){
        String senha;

        System.out.println("=============================================");
        System.out.println("A sua agencia eh " + agencia);
        System.out.println("O numero da sua conta eh " + numConta);
        System.out.println("Digite a senha numérica com 4 dígitos: ");
        senha = input.next();
        input.nextLine();

        return senha;
    }

    public static int confereSenha(){
        System.out.println("Digite a senha: ");
        Scanner leitura = new Scanner(System.in);

        String senha;

        senha = leitura.nextLine();
        input.nextLine(); // limpando o buffer


        if(!conta.getSenha().equals(senha)){
            throw new IllegalArgumentException("Senha incorreta!");
        }
        return 1;
    }

    public static void mostraDados(){
        String cpf;
        System.out.print("Digite seu CPF (sem pontuacao): ");
        cpf = input.next();

        try{
            ValidaCPF.isCPF(cpf);
            cliente = ArrayListFuncoes.buscaContaPorCPF(arrayClientes, cpf);
            cliente.mostraDados();
        } catch (IllegalArgumentException erro){
            System.out.println(erro.getMessage());
        }
    }
}
