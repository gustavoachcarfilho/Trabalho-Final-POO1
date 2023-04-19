import java.util.Scanner;

public class MenuTransacoes {
    public static Scanner input = new Scanner(System.in);
    public static void menu(Conta conta){
        int opcao = -1, s=0;
        float valor;

        while (opcao < 0 || opcao > 4) {
            System.out.println("===================");
            System.out.println("[1] Deposito");
            System.out.println("[2] Saque");
            System.out.println("[3] Consulta");
            System.out.println("[4] Pagamento");
            System.out.println("[0] Voltar");
            System.out.println("==================");
            opcao = input.nextInt();

            switch (opcao) {
                case (1):
                    System.out.print("Digite o valor a ser depositado: R$ ");
                    valor = input.nextFloat();
                    while (s != 1){
                        try{
                            s = MenuConta.confereSenha();
                        }
                        catch (IllegalArgumentException erro){
                            System.out.println(erro.getMessage());
                        }

                    }
                    conta.deposito(valor);
                    System.out.println("Valor depositado com sucesso!!");
                    break;
                case (2):
                    System.out.print("Digite o valor a ser sacado: R$ ");
                    valor = input.nextFloat();
                    while (s != 1){
                        try{
                            s = MenuConta.confereSenha();
                        }
                        catch (IllegalArgumentException erro){
                            System.out.println(erro.getMessage());
                        }

                    }
                    try{
                        conta.saque(valor);
                    }catch (IllegalArgumentException erro){
                        System.out.println(erro.getMessage());
                    }

                    break;
                case (3):
                    while (s != 1){
                        try{
                            s = MenuConta.confereSenha();
                        }
                        catch (IllegalArgumentException erro){
                            System.out.println(erro.getMessage());
                        }

                    }
                    conta.consulta();
                    break;
                case (4):
                    System.out.print("Digite o valor a ser pago: R$ ");
                    valor = input.nextFloat();
                    while (s != 1){
                        try{
                            s = MenuConta.confereSenha();
                        }
                        catch (IllegalArgumentException erro){
                            System.out.println(erro.getMessage());
                        }

                    }
                    try {
                        conta.pagamento(valor);
                    } catch (IllegalArgumentException erro){
                        System.out.println(erro.getMessage());
                    }
                    break;
                case (0):
                    return;
                default:
                    System.out.println("Valor inválido, digite o número de uma das opções!!");
            }
        }
    }
}
