import java.util.Scanner;

public class AgendaTelefonica {
    private static final ArvoreBST arvore = new ArvoreBST();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("=== AGENDA TELEFÔNICA (BST) ===");
        while(true){
            exibirMenu();
            System.out.println("Insira a opção desejada");
            int opcao = scanner.nextInt();
            scanner.nextLine();
            System.out.println();
            switch (opcao) {
                case 1:
                    inserirContato();
                    break;
                case 2:
                    buscarContato();
                    break;
                case 3:
                    removerContato();
                    break;
                case 4:
                    arvore.exibirEmOrdem();
                    break;
                case 5:
                    arvore.exibirPreOrdem();
                    break;
                case 6:
                    arvore.exibirPosOrdem();
                    break;
                case 7:
                    exibirPrimeiro();
                    break;
                case 8:
                    exibirUltimo();
                    break;
                case 9:
                    exibirQuantidade();
                    break;
                case 10:
                    exibirAltura();
                    break;
                case 11:
                    System.out.println("Encerrando o sistema. Até logo!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    pausar();
                    continue;
            }
            pausar();
        }
    }

    private static void inserirContato() {
        System.out.println("--- INSERIR CONTATO ---");
        String nome = lerString("Nome: ");

        if (nome.isEmpty()) {
            System.out.println("O nome não pode ser vazio.");
            return; 
        }

        String telefone = lerString("Telefone: ");
        if (telefone.isEmpty()){
            System.out.println("Telefone nao pode estar vazio");
            return;
        }
        String email = lerString("E-mail: ");
        if (email.isEmpty()){
            System.out.println("Email nao pode estar vazio");
            return;
        }

        String cidade = lerString("Cidade: ");
        if (cidade.isEmpty()){System.out.println("Cidade nao pode estar vazia");
            return;
        }

        if (arvore.inserir(new Contato(nome, telefone, email, cidade))) {
            System.out.println("\nContato \"" + nome + "\" inserido com sucesso!");
        }
        else {
            System.out.println("\nErro: Já existe um contato com o nome \"" + nome + "\".");
        }
    }

    private static void buscarContato() {
        System.out.println("--- BUSCAR CONTATO ---");
        String nome = lerString("Nome: ");
        Contato encontrado = arvore.buscar(nome);
        System.out.println(encontrado != null ? "\nContato encontrado:\n" + encontrado : "\nContato \"" + nome + "\" não encontrado.");
    }

    private static void removerContato() {
        System.out.println("--- REMOVER CONTATO ---");
        String nome = lerString("Nome: ");
        Contato encontrado = arvore.buscar(nome);

        if (encontrado == null) {
            System.out.println("\nContato \"" + nome + "\" não encontrado.");
            return;
        }

        System.out.println("\nContato a remover:\n" + encontrado);
        System.out.print("\nConfirma a remoção? (s/n): ");

        if (scanner.nextLine().trim().equalsIgnoreCase("s")) {
            arvore.remover(nome);
            System.out.println("\nContato \"" + nome + "\" removido com sucesso!");
        }
        else {
            System.out.println("\nRemoção cancelada.");
        }
    }



    private static void exibirPrimeiro() {
        System.out.println("--- PRIMEIRO CONTATO ---");
        System.out.println(arvore.estaVazia() ? "Nenhum contato cadastrado." : arvore.primeiro());
    }



    private static void exibirUltimo() {
        System.out.println("--- ÚLTIMO CONTATO ---");
        System.out.println(arvore.estaVazia() ? "Nenhum contato cadastrado." : arvore.ultimo());
    }



    private static void exibirQuantidade() {
        System.out.println("Total de contatos: " + arvore.quantidade());
    }


    private static void exibirAltura() {
        System.out.println(arvore.estaVazia() ? "Árvore vazia (altura = -1)" : "Altura da árvore: " + arvore.altura());
    }


    private static void exibirMenu() {
        System.out.println("\nMenu principal:\n1. Inserir contato" +
                "\n2. Buscar contato" +
                "\n3. Remover contato" +
                "\n4. Exibir (Em Ordem alfabética)" +
                "\n5. Exibir (Pré-Ordem)" +
                "\n6. Exibir (Pós-Ordem)" +
                "\n7. Primeiro contato alfabeticamente" +
                "\n8. Último contato alfabeticamente" +
                "\n9. Total de contatos" +
                "\n10. Altura da árvore" +
                "\n11. Sair");
    }



    private static String lerString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private static void pausar() {
        System.out.print("\nPressione ENTER para continuar...");
        scanner.nextLine();
    }

}





