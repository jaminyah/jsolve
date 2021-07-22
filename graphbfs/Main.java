/**
 * Reference: java2blog.com
 * Compile: javac graphbfs/Node.java graphbfs/Graph.java graphbfs/Main.java
 * Run: java graphbfs/Main
 */

package graphbfs;

class Main {
    public static void main(String[] args) {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        node4.addChild(node1);
        node4.addChild(node2);
        node1.addChild(node3);
        node2.addChild(node1);
        node2.addChild(node3);
        node2.addChild(node6);
        node2.addChild(node5);
        node3.addChild(node6);
        node6.addChild(node7);
        node5.addChild(node7);

        Graph graph = new Graph();
        graph.bfs(node4);
        System.out.println();
    }
}