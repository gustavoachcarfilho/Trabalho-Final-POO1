import java.io.Serializable;
import  java.util.Scanner;
public class MenuInicial implements Serializable {
    static Scanner input = new Scanner(System.in);
    static int opcao = 1;
    public static void menu(){
        ArquivoTransacao.leituraTransacao();
        MenuConta.lerArquivoCliente();
        while(opcao != 0) {
            System.out.println("============== Seja bem-vindo ============");
            System.out.println("[1] Entrar na conta"); // um cliente pode ter diferentes contas
            System.out.println("[2] Cadastrar uma conta"); //verificar se o cliente ja possui uma conta
            System.out.println("[3] Desativar uma conta");
            System.out.println("[4] Ver dados da conta");
            System.out.println("[0] Sair");
            System.out.println("==========================================");
            opcao = input.nextInt();

            if (opcao == 1) {
                MenuConta.entrarConta();
            }
            if (opcao == 2) {
                MenuConta.cadastrarConta();
            }
            if (opcao == 3) {
                MenuConta.desativarConta();
            }
            if (opcao == 4) {
                MenuConta.mostraDados();
            }
        }
        ArquivoTransacao.escreveArquivo();
        MenuConta.escreveArquivoCliente();
        System.exit(0);
    }
}
