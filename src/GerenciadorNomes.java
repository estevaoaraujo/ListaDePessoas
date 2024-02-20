import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorNomes {
    private ArrayList<String> listaNomes;
    static Scanner scanner;


    public GerenciadorNomes() {
        this.listaNomes = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void adicionarNome() {
        System.out.print("Digite um nome: ");
        String nome = scanner.nextLine();
        listaNomes.add(nome);
        System.out.println("Nome adicionado com sucesso!");
    }

    public void salvarNomes(String caminhoArquivo) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo, true))) {
            for (String nome : listaNomes) {
                writer.write(nome);
                writer.newLine();
            }
            System.out.println("Nomes salvos com sucesso em: " + caminhoArquivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void consultarNomes(String caminhoArquivo) {
        try {
            Path path = FileSystems.getDefault().getPath(caminhoArquivo);

            // Cria o arquivo se ele não existir
            if (!Files.exists(path)) {
                Files.createFile(path);
                System.out.println("Arquivo " + caminhoArquivo + " criado com sucesso.");
                return;
            }

            // Continua com a leitura se o arquivo já existe
            try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
                System.out.println("Nomes no arquivo:");
                String linha;
                while ((linha = reader.readLine()) != null) {
                    System.out.println(linha);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}


