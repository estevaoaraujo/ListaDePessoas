public class Main {
    public static void main(String[] args) {
        GerenciadorNomes gerenciador = new GerenciadorNomes();

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Adicionar nome");
            System.out.println("2. Consultar nomes");
            System.out.println("3. Sair");

            try {
                int opcao = Integer.parseInt(GerenciadorNomes.scanner.nextLine());

                switch (opcao) {
                    case 1:
                        gerenciador.adicionarNome();
                        gerenciador.salvarNomes("nomes.txt");
                        break;
                    case 2:
                        gerenciador.consultarNomes("nomes.txt");
                        break;
                    case 3:

                        System.out.println("Saindo do programa.");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, insira um número válido.");
            }
        }
    }
}
