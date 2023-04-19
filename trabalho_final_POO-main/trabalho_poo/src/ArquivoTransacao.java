import java.io.*;
import java.util.ArrayList;

public class ArquivoTransacao implements Serializable {

    public static ArrayList<Transacao> arrayListTransacao = new ArrayList<>();
    public ArquivoTransacao(){};
    public static void escreveTransacao(Transacao transacao){
        arrayListTransacao.add(transacao);
    }

    public static void leituraTransacao(){
        try {
            FileInputStream arquivo = new FileInputStream("C:\\Users\\guilherme\\OneDrive - Universidade Federal de Uberlândia\\repositorios-github-ufu\\trabalho_final_POO\\arquivos\\dadosTransacao.dat");
            ObjectInputStream referencia = new ObjectInputStream(arquivo);
            arrayListTransacao = (ArrayList<Transacao>) referencia.readObject();
            referencia.close();
            arquivo.close();
        } catch (IOException e) {
            System.out.println("Erro na leitura do objeto transacao" + e);
        } catch (ClassNotFoundException e) {
            System.out.println("Classe nao encontrada" + e);
        }
    }

    public static void escreveArquivo(){
        int cont;
        try {
            FileOutputStream arquivo = new FileOutputStream("C:\\Users\\guilherme\\OneDrive - Universidade Federal de Uberlândia\\repositorios-github-ufu\\trabalho_final_POO\\arquivos\\dadosTransacao.dat");
            ObjectOutputStream referencia = new ObjectOutputStream(arquivo);
            referencia.writeObject(arrayListTransacao);
//            for(cont = 0; cont < arrayListTransacao.size(); cont++){
//                arrayListTransacao.get(cont).mostraDados();
//            }
            referencia.close();
            arquivo.close();
        } catch (FileNotFoundException e) {
            System.out.println("Erro ao encontrar o arquivo de transacoes" + e);
        } catch (IOException e) {
            System.out.println("Erro na escrita do objeto transacao" + e);
        }
    }
}