//essa é a arvore organizada por ordem alfabetica

public class SearchTreeByName {
    private TreeNodeByName root;


    public SearchTreeByName() {
        this.root = null;
    }

//metodo de adicao na arvore por Nome
    public void addNode(Product product) {
        TreeNodeByName newNode = new TreeNodeByName(product);

        if (root == null) {
            root = newNode;
        } else {
            TreeNodeByName currentNode = root;
            TreeNodeByName parent;

            while (true) {
                parent = currentNode;

                if (product.getName().compareTo(currentNode.getProduct().getName()) < 0) {
                    currentNode = currentNode.getLeft();

                    if (currentNode == null) {
                        parent.setLeft(newNode);
                        return;
                    }
                } else {
                    currentNode = currentNode.getRight();

                    if (currentNode == null) {
                        parent.setRight(newNode);
                        return;
                    }
                }
            }
        }
    }




    public void removeProductBN(String name) {
        root = removeNode(root, name);
    }

    private TreeNodeByName removeNode(TreeNodeByName currentNode, String name) {
        if (currentNode == null) {
            // Caso base: nó não encontrado, retorna null
            return null;
        }

        if (name.compareTo(currentNode.getProduct().getName()) < 0) {
            // Se o nome a ser removido for menor, continua a busca na subárvore esquerda
            currentNode.setLeft(removeNode(currentNode.getLeft(), name));
        } else if (name.compareTo(currentNode.getProduct().getName()) > 0) {
            // Se o nome a ser removido for maior, continua a busca na subárvore direita
            currentNode.setRight(removeNode(currentNode.getRight(), name));
        } else {
            // Nó encontrado para remoção
            if (currentNode.getLeft() == null && currentNode.getRight() == null) {
                // Caso 1: nó não possui filhos
                return null;
            } else if (currentNode.getLeft() == null) {
                // Caso 2: nó possui apenas filho à direita
                return currentNode.getRight();
            } else if (currentNode.getRight() == null) {
                // Caso 3: nó possui apenas filho à esquerda
                return currentNode.getLeft();
            } else {
                // Caso 4: nó possui dois filhos
                TreeNodeByName successor = findMinimumNode(currentNode.getRight());
                // Encontra o sucessor do nó na subárvore direita (menor nó da subárvore direita)
                currentNode.setProduct(successor.getProduct());
                // Substitui os valores do nó atual pelos valores do sucessor
                currentNode.setRight(removeNode(currentNode.getRight(), successor.getProduct().getName()));
                // Remove recursivamente o sucessor da subárvore direita
            }
        }

        return currentNode;
    }

    private TreeNodeByName findMinimumNode(TreeNodeByName node) {
        if (node.getLeft() == null) {
            // Encontrou o nó mínimo (não possui filho à esquerda)
            return node;
        }
        // Continua a busca na subárvore esquerda
        return findMinimumNode(node.getLeft());
    }
    //metodo usado para fazer alteracoes na quantidade
    public void updateQuantityBN(String name, int newQuantity) {
        TreeNodeByName nodeToUpdate = searchNode(root, name);
        if (nodeToUpdate != null) {
            nodeToUpdate.getProduct().setQuantity(newQuantity);
        }
    }
//com base no NÓ ele busca pelo produto com base no nome
    public Product searchProductBN(String name) {
        // Chama o método searchNode para encontrar o nó correspondente na árvore
        TreeNodeByName resultNode = searchNode(root, name);

        // Verifica se o nó foi encontrado
        if (resultNode != null) {
            // Retorna o objeto Product associado ao nó encontrado
            return resultNode.getProduct();
        } else {
            // Caso o nó não tenha sido encontrado, retorna null
            return null;
        }
    }

    //Metodo de busca pelo NÓ na arvore
    private TreeNodeByName searchNode(TreeNodeByName currentNode, String name) {
        // Verifica se o nó atual é nulo ou se o nome do produto associado ao nó é igual ao nome fornecido
        if (currentNode == null || currentNode.getProduct().getName().equals(name)) {
            // Retorna o nó atual caso seja nulo ou se o nome do produto é igual ao nome fornecido
            return currentNode;
        }

        // Compara o nome fornecido com o nome do produto atual no nó
        if (name.compareTo(currentNode.getProduct().getName()) < 0) {
            // Se o nome fornecido for menor, realiza a busca na subárvore esquerda
            return searchNode(currentNode.getLeft(), name);
        } else {
            // Caso contrário, o nome fornecido é maior, então realiza a busca na subárvore direita
            return searchNode(currentNode.getRight(), name);
        }
    }





}
