//A classe ProductTree representa uma árvore binária de busca que organiza os produtos armazenados no estoque.
// Ela é composta por nós do tipo TreeNode e possui uma referência para o nó raiz da árvore.
// A classe contém métodos para adicionar um produto na árvore, remover um produto, atualizar a quantidade de um produto e buscar um nó específico na árvore.
// Esses métodos são implementados de forma recursiva, percorrendo a árvore e ajustando os nós conforme necessário.
// A classe também fornece um método para obter a referência do nó raiz.
// Essa estrutura de árvore facilita a busca e manipulação eficiente dos produtos no estoque.

import java.util.ArrayList;
import java.util.List;

public class ProductTree {
    private TreeNode root;

    public ProductTree() {
        root = null;
    }

    public void addProduct(Product product) {
        root = addProductRec(root, product);
    }

    private TreeNode addProductRec(TreeNode root, Product product) {
        if (root == null) {
            return new TreeNode(product);
        }

        if (product.getCode() < root.getProduct().getCode()) {
            root.setLeft(addProductRec(root.getLeft(), product));
        } else if (product.getCode() > root.getProduct().getCode()) {
            root.setRight(addProductRec(root.getRight(), product));
        }

        return root;
    }

    public void removeProduct(int code) {
        root = removeProductRec(root, code);
    }

    private TreeNode removeProductRec(TreeNode root, int code) {
        if (root == null) {
            return null;
        }

        if (code < root.getProduct().getCode()) {
            root.setLeft(removeProductRec(root.getLeft(), code));
        } else if (code > root.getProduct().getCode()) {
            root.setRight(removeProductRec(root.getRight(), code));
        } else {
            if (root.getLeft() == null) {
                return root.getRight();
            } else if (root.getRight() == null) {
                return root.getLeft();
            }

            TreeNode minNode = findMin(root.getRight());
            root.setProduct(minNode.getProduct());
            root.setRight(removeProductRec(root.getRight(), minNode.getProduct().getCode()));
        }

        return root;
    }

    public void updateQuantity(int code, int quantity) {
        TreeNode node = findProductNode(root, code);
        if (node != null) {
            node.getProduct().setQuantity(quantity);
            System.out.println("Quantidade atualizada com sucesso!");
        } else {
            System.out.println("Produto não encontrado!");
        }
    }

    private TreeNode findProductNode(TreeNode root, int code) {
        if (root == null || root.getProduct().getCode() == code) {
            return root;
        }

        if (code < root.getProduct().getCode()) {
            return findProductNode(root.getLeft(), code);
        }

        return findProductNode(root.getRight(), code);
    }

    private TreeNode findMin(TreeNode root) {
        if (root == null || root.getLeft() == null) {
            return root;
        }

        return findMin(root.getLeft());
    }

    public TreeNode getRoot() {
        return root;
    }

    public Product searchProductByCode(int code) {
        return searchProductByCode(root, code);
    }

    private Product searchProductByCode(TreeNode node, int code) {
        if (node == null) {
            return null;
        }

        int compare = Integer.compare(code, node.getProduct().getCode());
        if (compare == 0) {
            return node.getProduct();
        } else if (compare < 0) {
            return searchProductByCode(node.getLeft(),code);
        } else {
            return searchProductByCode(node.getRight(), code);
        }
    }






    private Product searchProductByPriceRec(TreeNode root, double price) {
        if (root == null) {
            return null;
        }

        if (price == root.getProduct().getPrice()) {
            return root.getProduct();
        } else if (price < root.getProduct().getPrice()) {
            return searchProductByPriceRec(root.getLeft(), price);
        } else {
            return searchProductByPriceRec(root.getRight(), price);
        }
    }

}
