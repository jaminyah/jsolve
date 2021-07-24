/**
 * Ref: https://www.baeldung.com/java-binary-tree
 */

package binary_tree;

public class Main {
    public static void main(String[] args) {

        BinaryTree bTree = new BinaryTree();
        bTree.addNode(6);
        bTree.addNode(4);
        bTree.addNode(8);
        bTree.addNode(3);
        bTree.addNode(5);
        bTree.addNode(7);
        bTree.addNode(9);

        Node root = bTree.rootNode;
        bTree.dfsPreOrder(root);
        System.out.println();

        bTree.dfsInOrder(root);
        System.out.println();

        bTree.dfsPostOrder(root);
        System.out.println();

        bTree.bfs();
        System.out.println();

        System.out.println("bTree.contains(5): " + bTree.contains(5));
    }
}
