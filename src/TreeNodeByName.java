public class TreeNodeByName {
    private Product product;
    private TreeNodeByName left;
    private TreeNodeByName right;

    public TreeNodeByName(Product product) {
        this.product = product;
        this.left = null;
        this.right = null;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public TreeNodeByName getLeft() {
        return left;
    }

    public void setLeft(TreeNodeByName left) {
        this.left = left;
    }

    public TreeNodeByName getRight() {
        return right;
    }

    public void setRight(TreeNodeByName right) {
        this.right = right;
    }
}