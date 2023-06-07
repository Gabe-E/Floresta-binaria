//A classe Utils contém métodos utilitários para auxiliar na exibição das informações de um produto.
// O método displayProduct recebe um objeto Product como parâmetro e imprime na tela
// os detalhes desse produto, incluindo código, nome, quantidade e preço.
// Essa classe é utilizada pela classe InventoryManagementSystem para exibir os produtos do estoque de forma formatada.
// Os métodos dessa classe oferecem uma funcionalidade reutilizável para exibir informações específicas de um produto
// em diferentes partes do programa.
public class Utils {
    public static void displayProduct(Product product) {
        System.out.println("Código: " + product.getCode());
        System.out.println("Nome: " + product.getName());
        System.out.println("Quantidade: " + product.getQuantity());
        System.out.println("Preço: " + product.getPrice());
        System.out.println("-------------------------");
    }
}
