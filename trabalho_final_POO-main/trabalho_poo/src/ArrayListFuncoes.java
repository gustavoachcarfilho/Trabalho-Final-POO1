import java.security.InvalidParameterException;
import java.util.ArrayList;

public class ArrayListFuncoes {
    public static int mostraContasPorCPF(ArrayList<Clientes> arrayListClientes, String cpf){
        int cont, pos = -1;

        for(cont = 0; cont < arrayListClientes.size(); cont++){
            if(arrayListClientes.get(cont).cpf.equals(cpf)){
                arrayListClientes.get(cont).mostraDados();
                pos = cont;
                return pos;
            }
        }
        throw new InvalidParameterException("CPF não encontrado, favor cadastrar uma conta.");
    }

    public static Conta buscaContasPorNumero(ArrayList<Clientes> arrayListClientes, int pos, int numConta){
        int cont;

        for(cont = 0; cont < arrayListClientes.get(pos).arrayContas.size(); cont++){
            if(arrayListClientes.get(pos).arrayContas.get(cont).numeroConta == numConta && arrayListClientes.get(pos).arrayContas.get(cont).getStatus() == true){
                return arrayListClientes.get(pos).arrayContas.get(cont);
            }
        }

        throw new InvalidParameterException("Conta não encontrada.");
    }

    public static Clientes buscaContaPorCPF(ArrayList<Clientes> arrayListClientes, String cpf){
        int cont;

        for(cont = 0; cont < arrayListClientes.size(); cont++){
            if(arrayListClientes.get(cont).cpf.equals(cpf)){
                return arrayListClientes.get(cont);
            }
        }
        throw new InvalidParameterException("Conta não encontrada.");
    }

    public static boolean adicionaConta(Clientes cliente, Conta conta){
        if(conta != null){
            return cliente.arrayContas.add(conta);
        }
        throw new NullPointerException("Falha ao criar a conta, tente novamente mais tarde!!");
    }

    public static boolean desativarContasPorNumero(ArrayList<Clientes> arrayListClientes, int pos, int numConta){
        int cont;

        for(cont = 0; cont < arrayListClientes.get(pos).arrayContas.size(); cont++){
            if(arrayListClientes.get(pos).arrayContas.get(cont).numeroConta == numConta){
                arrayListClientes.get(pos).arrayContas.get(cont).setStatus(false);
                return true;
            }
        }
        throw new InvalidParameterException("Conta não encontrada.");
    }

}
