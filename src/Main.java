import java.util.Scanner;
import java.text.Normalizer;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InventoryManagementSystem inventorySystem = new InventoryManagementSystem();



        boolean running = true;
        while (running) {
            System.out.println("===== Gerenciamento de Estoque =====");
            System.out.println("1. Adicionar produto");
            System.out.println("2. Remover produto");
            System.out.println("3. Atualizar quantidade em estoque");
            System.out.println("4. Exibir estoque");
            System.out.println("5. Buscar produto por nome");
            System.out.println("6. Buscar produto por Código");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.println("===== Adicionar Produto =====");

                    String name;
                    boolean nameExists = false;
                    boolean codeExists = false;
                    //loop para entrada de dados para nomes string no caso ele utiliza o normalizer para poder comparar
                    //os caracteres independentes de acento de uppercase,ele faz uma busca para verificar se ja existe o
                    //produto
                    do {
                        System.out.print("Nome: ");
                        name = scanner.nextLine();
                        name=name.toLowerCase();
                        String normalized = Normalizer.normalize(name, Normalizer.Form.NFD);
                        normalized =normalized.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
                        name = normalized;
                        Product foundByName = inventorySystem.searchProductBNIMS(name);
                        if (foundByName != null) {
                            nameExists=true;
                            System.out.println("Nome de produto já inserido. Insira outro nome");
                        }else{nameExists=false;}
                    } while (name.trim().isEmpty() || nameExists);
                    //loop para entrada de dados codigo int
                    //faz uma busca para verificar se o codigo ja existe
                    int code;
                    do {
                        System.out.print("Código: ");
                        code = scanner.nextInt();
                        scanner.nextLine();
                        Product foundByCode = inventorySystem.searchProduct(code);
                        if (foundByCode != null) {
                            codeExists = true;
                            System.out.println("Código do produto já inserido. Insira outro Código");
                        } else {codeExists=false;}
                    } while (code == 0 || codeExists);
                    //loop para entrada de dados quantidade int

                    int quantity;
                    do {
                        System.out.print("Quantidade: ");
                        quantity = scanner.nextInt();
                        scanner.nextLine();
                    } while (quantity == 0 );
                    //loop para entrada de dados preço double
                    double price;
                    do {
                        System.out.print("Preço: ");
                        price = scanner.nextDouble();
                        scanner.nextLine();
                    } while (price == 0.0);

                    Product product = new Product(code, name, quantity, price);
                    //depois de criado o produto adicionar na arvore inventory system /treeByName(organiza arvore com base no nome)/treeByCode(organiza arvore com base no codigo)
                    inventorySystem.addProduct(product);


                    System.out.println("Produto adicionado ao estoque.");
                    System.out.println("\nEnter para continuar");
                    scanner.nextLine();
                    break;

                case 2:
                    System.out.println("===== Remover Produto =====");
                    int choose;
                    do{
                        System.out.println("=====Insira====");
                        System.out.println("(1)Para Remover por Meio do Código do Produto");
                        System.out.println("(2)Para Remover por Meio do Nome do Produto");
                        choose = scanner.nextInt();
                    }while (0>choose||choose>2);
                    scanner.nextLine();
                    switch (choose){
                        case 1:
                            System.out.print("Código do produto a ser removido: ");
                            int removeCode = scanner.nextInt();
                            Product foundByCode = inventorySystem.searchProduct(removeCode);
                            if (foundByCode != null) {
                                inventorySystem.removeProduct(removeCode);
                                System.out.println("Produto removido do estoque.");
                            }else {System.out.println("Código do produto inserido não registrado. Insira outro Código");}

                            break;
                        case 2:System.out.print("Nome do produto a ser removido: ");
                            String removeName = scanner.nextLine();
                            Product foundByName = inventorySystem.searchProductBNIMS(removeName);
                            if (foundByName != null) {

                                inventorySystem.removeProductBNIMS(removeName);
                                System.out.println("Produto removido do estoque.");

                            } else {
                                System.out.println("Código do produto inserido não registrado. Insira outro Código");
                            }

                            break;
                    }

                    break;

                case 3:
                    System.out.println("===== Atualizar Quantidade em Estoque =====");
                    int chooseUp;
                    do{
                        System.out.println("=====Insira====");
                        System.out.println("(1)Para Atualizar Quantidade em Estoque  por Meio do Código do Produto");
                        System.out.println("(2)Para Atualizar Quantidade em Estoque  por Meio do Nome do Produto");
                        chooseUp = scanner.nextInt();
                    }while (0>chooseUp||chooseUp>2);
                    scanner.nextLine();
                    switch (chooseUp){
                        case 1:
                            System.out.print("Código do produto: ");
                            int updateCode = scanner.nextInt();
                            Product foundByCode = inventorySystem.searchProduct(updateCode);
                            if (foundByCode != null) {
                                System.out.print("Nova quantidade: ");
                                int newQuantity = scanner.nextInt();
                                inventorySystem.updateQuantity(updateCode, newQuantity);
                                System.out.println("Quantidade em estoque atualizada.");



                            } else {System.out.println("Código do produto inserido não registrado. Insira outro Código");}

                            break;
                        case 2:
                            System.out.print("Nome do produto: ");
                            String updateName = scanner.nextLine();
                            Product foundByName = inventorySystem.searchProductBNIMS(updateName);
                            if (foundByName != null) {
                                System.out.print("Nova quantidade: ");
                                int newQuantity = scanner.nextInt();
                                inventorySystem.updateQuantityBN(updateName, newQuantity);
                                System.out.println("Quantidade em estoque atualizada.");

                            } else {
                                System.out.println("Código do produto inserido não registrado. Insira outro Código");
                            }
                            break;
                    }

                    break;

                case 4:
                    System.out.println("===== Exibir Estoque =====");
                    inventorySystem.displayInventory();
                    System.out.println("\nEnter para continuar");
                    scanner.nextLine();
                    break;
                case 5:
                    System.out.println("===== Buscar Produto por Nome =====");
                    System.out.print("Nome do produto: ");
                    String searchName = scanner.nextLine();
                    Product foundByName = inventorySystem.searchProductBNIMS(searchName);
                    if (foundByName != null) {
                        Utils.displayProduct(foundByName);
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    System.out.println("\nEnter para continuar");
                    scanner.nextLine();
                    break;
                case 6:
                    System.out.println("===== Buscar Produto por Código do Produto =====");
                    System.out.print("Código do Produto: ");
                    int searchCode = scanner.nextInt();
                    Product foundByCode = inventorySystem.searchProduct(searchCode);
                    if (foundByCode != null) {
                        Utils.displayProduct(foundByCode);
                        // utils display vai mostrar o produto
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    System.out.println("\nEnter para continuar");
                    scanner.nextLine();
                    scanner.nextLine(); // Adicione uma chamada extra para consumir a nova linha pendente
                    break;


                case 7:
                    running = false;
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
            }

            System.out.println();
        }

        scanner.close();
    }
}
