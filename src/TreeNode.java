//A classe TreeNode representa um nó de uma árvore binária de busca.
// Cada nó contém um objeto do tipo Product, representando um produto, bem como referências para os nós filhos esquerdo e direito.
// Essa classe é utilizada pela classe ProductTree para construir a estrutura da árvore.
// O nó possui um construtor que recebe um produto e inicializa as referências dos nós filhos como nulas.
// Através dos métodos getters e setters, é possível obter e modificar o produto associado ao nó, bem como acessar os nós filhos.
// Essa classe desempenha um papel fundamental na implementação da árvore de produtos e suas operações.

public class TreeNode {
    private Product product;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(Product product) {
        this.product = product;
        this.left = null;
        this.right = null;
    }

    public Product getProduct() {
        return product;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public void setProduct(Product product) {
    }
}
