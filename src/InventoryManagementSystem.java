//A classe InventoryManagementSystem é responsável por gerenciar o estoque de produtos.
// Ela utiliza uma estrutura de árvore binária de busca do tipo ProductTree e o SearchtreeByName para armazenar os produtos de forma organizada.
// A classe possui métodos para adicionar um produto ao estoque, remover um produto, atualizar a quantidade de um produto e exibir o estoque atual.
// Esses métodos interagem com a árvore de produtos e realizam as operações correspondentes.
// A classe também utiliza a classe Utils para exibir as informações dos produtos de forma legível.
// O InventoryManagementSystem é a classe principal que coordena as funcionalidades de gerenciamento do estoque
// e é utilizada pela classe Main para interagir com o usuário através de um menu de opções.

import java.util.Scanner;

public class InventoryManagementSystem {
    private SearchTreeByName searchTreeByName;
    private ProductTree searchTreeByCode;

    public InventoryManagementSystem() {
        searchTreeByName = new SearchTreeByName();
        searchTreeByCode = new ProductTree();

    }


    public void removeProduct(int code) {
        Product SearchName = searchTreeByCode.searchProductByCode(code);
        searchTreeByName.removeProductBN(SearchName.getName());
        searchTreeByCode.removeProduct(code);
        System.out.println("Produto removido com sucesso!");
    }



    public void removeProductBNIMS(String name) {
        Product SearchCode = searchTreeByName.searchProductBN(name);
        searchTreeByCode.removeProduct(SearchCode.getCode());
        searchTreeByName.removeProductBN(name);
        System.out.println("Produto removido com sucesso!");
    }



    public void updateQuantity(int code, int quantity) {
        Product SearchName = searchTreeByCode.searchProductByCode(code);
        searchTreeByName.updateQuantityBN(SearchName.getName(),quantity);
        searchTreeByCode.updateQuantity(code, quantity);
        System.out.println("Quantidade atualizada com sucesso!");
    }



    public void updateQuantityBN(String name, int quantity) {
        Product SearchCode = searchTreeByName.searchProductBN(name);
        searchTreeByName.updateQuantityBN(name,quantity);
        searchTreeByCode.updateQuantity(SearchCode.getCode(), quantity);
        System.out.println("Quantidade atualizada com sucesso!");
    }



    public void displayInventory() {
        System.out.println("Estoque:");

            displayProductTree(searchTreeByCode.getRoot());

    }
//o display nao faz por ordem de insercao JULIA. é por ordem de MENOR PARA MAIOR.lembra da minha mini aula que eu contei
//todoempolgado    NÃO?pois devia né!sabia?pois agora esta sabendo!(olho levantando e outro fechando)
    private void displayProductTree(TreeNode root) {
        if (root != null) {
            displayProductTree(root.getLeft());
            Utils.displayProduct(root.getProduct());
            displayProductTree(root.getRight());
        }
    }



    public Product searchProduct(Integer keyword) {return searchTreeByCode.searchProductByCode(keyword);}
    public Product searchProductBNIMS(String keyword){return searchTreeByName.searchProductBN(keyword);}



    public void addProduct(Product product) {
        searchTreeByName.addNode(product);
        searchTreeByCode.addProduct(product);
        System.out.println("Produto adicionado com sucesso!");
    }
}




