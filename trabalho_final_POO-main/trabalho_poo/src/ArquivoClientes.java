import java.io.*;
import java.util.ArrayList;

public class ArquivoClientes implements Serializable {
    public static ArrayList<Clientes> arrayClientes = new ArrayList<>();

    public static ArrayList<Clientes> leituraArquivoClientes(){
        try{
            // "C:\\Users\\gustavofilho\\Downloads\\Faculdade\\GitHub POO\\trabalho_final_POO\\arquivos\\dadosClientes.dat"
            FileInputStream arquivo = new FileInputStream("C:\\Users\\guilherme\\OneDrive - Universidade Federal de Uberlândia\\repositorios-github-ufu\\trabalho_final_POO\\arquivos\\dadosClientes.dat");
            ObjectInputStream referencia = new ObjectInputStream(arquivo);
            arrayClientes = (ArrayList<Clientes>) referencia.readObject();
            referencia.close();
            arquivo.close();
        } catch (IOException e){
            System.out.println("Erro na leitura do objeto cliente " + e);
        } catch (ClassNotFoundException e){
            System.out.println("Classe nao encontrada " + e);
        }
        return arrayClientes;
    }

    public static void escreveArquivoClientes(){
        int cont;

        try{
            FileOutputStream arquivo = new FileOutputStream("C:\\Users\\guilherme\\OneDrive - Universidade Federal de Uberlândia\\repositorios-github-ufu\\trabalho_final_POO\\arquivos\\dadosClientes.dat");
            ObjectOutputStream referencia = new ObjectOutputStream(arquivo);
            referencia.writeObject(arrayClientes);
//            for(cont = 0; cont < arrayClientes.size(); cont++){
//                arrayClientes.get(cont).mostraDados();
//            }
            referencia.close();
            arquivo.close();
        } catch (FileNotFoundException e){
            System.out.println("Erro ao encontrar o arquivo de clientes" + e);
            e.printStackTrace();
        } catch (IOException e){
            System.out.println("Erro na escrita do objeto cliente" + e);
            e.printStackTrace();
        }
    }
}
