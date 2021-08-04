package find_cycle_directed;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Node {

    int data;
    boolean isVisited;
    boolean isBeingVisited;
    List<Node> children;

    Node(int data) {
        this.data = data;
        this.isVisited = false;
        this.isBeingVisited = false;
        this.children = new ArrayList<>();
    }

    public void addChild(Node node) {
        this.children.add(node);
    }

    public List<Node> getChildren() {
        return this.children;
    }
}

class Main {
    public static void main(String[] args) {

        // Edge list
        // int[][] e = { {}, { 0, 3 }, { 0 }, { 1, 2 } };
        int[][] e = { { 1 }, { 2, 3, 4, 5, 6, 7 }, {}, { 2, 7 }, { 5 }, {}, { 4 }, {} };

        boolean found = findCycle(e);
        System.out.println("Found: " + found);
    }

    static boolean findCycle(int[][] edges) {
        List<Node> parents = createGraph(edges);
        boolean status = dfsAll(parents);
        return status;
    }

    static List<Node> createGraph(int[][] vertices) {

        int len;
        int data;
        List<Node> parents = new ArrayList<>();

        for (int i = 0; i < vertices.length; i++) {
            Node parent = new Node(i);
            parents.add(parent);

            len = vertices[i].length;
            for (int j = 0; j < len; j++) {
                data = vertices[i][j];
                Node node = new Node(data);
                parent.addChild(node);
            }
        }

        return parents;
    }

    static boolean dfsAll(List<Node> graph) {

        boolean cycleDetected = false;

        for (Node startNode : graph) {
            if (startNode.isVisited == false) {
                cycleDetected = dfsCycleDetected(graph, startNode);
                if (cycleDetected == true) {
                    break;
                }
            }
        }
        return cycleDetected;
    }

    static boolean dfsCycleDetected(List<Node> g, Node node) {

        boolean detected = false;

        if (node.isVisited == true) {
            return false;
        }

        if (node.isBeingVisited == true) {
            return true;
        }

        node.isBeingVisited = true;
        List<Node> childNodes = g.get(node.data).getChildren();

        for (Node child : childNodes) {
            if (child != null && child.isVisited == false) {
                detected = dfsCycleDetected(g, child);
                if (detected == true) {
                    break;
                }
            }
        }
        node.isBeingVisited = false;
        node.isVisited = true;
        return detected;
    }
}
