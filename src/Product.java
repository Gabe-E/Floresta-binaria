
//A classe Product representa um produto com suas informações, como código, nome, quantidade e preço.
// Ela é utilizada pela classe InventoryManagementSystem para manipular os produtos do estoque.
// A classe possui um construtor que recebe os valores iniciais do produto e métodos getters para obter os valores dos atributos.
// Além disso, possui métodos setters para atualizar a quantidade e o preço do produto.
// Essa classe é essencial para o funcionamento do sistema de gerenciamento de estoque, pois permite a criação e manipulação dos produtos armazenados.
public class Product {
    private int code;
    private String name;
    private int quantity;
    private double price;

    public Product(int code, String name, int quantity, double price) {
        this.code = code;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
