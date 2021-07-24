/**
 * Ref: https://www.baeldung.com/java-binary-tree
 */

package binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    Node rootNode;

    /**** INSERT NODES RECURSIVELY ****/

    public void addNode(int value) {
        rootNode = addRecur(rootNode, value);
    }

    private Node addRecur(Node startNode, int value) {
        if (startNode == null) {
            return new Node(value);
        }

        if (value < startNode.value) {
            startNode.leftNode = addRecur(startNode.leftNode, value);
        } else if (value > startNode.value) {
            startNode.rightNode = addRecur(startNode.rightNode, value);
        } else {
            return startNode;
        }
        return startNode;
    }

    /**** DEPTH FIRST TREE TRAVERSAL ****/

    public void dfsPreOrder(Node startNode) {
        if (startNode != null) {
            System.out.print(startNode.value + ", ");
            dfsPreOrder(startNode.leftNode);
            dfsPreOrder(startNode.rightNode);
        }
    }

    public void dfsInOrder(Node startNode) {
        if (startNode != null) {
            dfsInOrder(startNode.leftNode);
            System.out.print(startNode.value + ", ");
            dfsInOrder(startNode.rightNode);
        }
    }

    public void dfsPostOrder(Node startNode) {
        if (startNode != null) {
            dfsPostOrder(startNode.leftNode);
            dfsPostOrder(startNode.rightNode);
            System.out.print(startNode.value + ", ");
        }
    }

    /**** BREADTH FIRST TREE TRAVERSAL ****/

    public void bfs() {
        if (rootNode == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(rootNode);

        while (queue.isEmpty() == false) {

            Node firstNode = queue.remove();
            System.out.print(firstNode.value + ", ");

            if (firstNode.leftNode != null) {
                queue.add(firstNode.leftNode);
            }

            if (firstNode.rightNode != null) {
                queue.add(firstNode.rightNode);
            }
        }
    }

    /**** TREE CONTAINS NODE WITH VALUE ****/

    public boolean contains(int value) {
        return containsRecursive(rootNode, value);
    }

    private boolean containsRecursive(Node startNode, int value) {
        if (startNode == null) {
            return false;
        }

        if (value == startNode.value) {
            return true;
        }

        if (value < startNode.value) {
            return containsRecursive(startNode.leftNode, value);
        } else {
            return containsRecursive(startNode.rightNode, value);
        }
    }

    /**** DELETE NODE WITH VALUE ****/

    public void delete(int value) {
        rootNode = deleteRecursive(rootNode, value);
    }

    private Node deleteRecursive(Node startNode, int value) {
        if (startNode == null) {
            return null;
        }

        if (value == startNode.value) {

            // Case 1: no children
            if (startNode.leftNode == null && startNode.rightNode == null) {
                return null;
            }

            // Case 2: only 1 child
            if (startNode.rightNode == null) {
                return startNode.leftNode;
            }

            if (startNode.leftNode == null) {
                return startNode.rightNode;
            }

            // Case 3: 2 children
            int smallestValue = findSmallestValue(startNode.rightNode);
            startNode.value = smallestValue;
            startNode.rightNode = deleteRecursive(startNode.rightNode, smallestValue);
            return startNode;
        }
        if (value < startNode.value) {
            startNode.leftNode = deleteRecursive(startNode.leftNode, value);
            return startNode;
        }

        startNode.rightNode = deleteRecursive(startNode.rightNode, value);
        return startNode;
    }

    private int findSmallestValue(Node rootNode) {
        return rootNode.leftNode == null ? rootNode.value : findSmallestValue(rootNode.leftNode);
    }
}