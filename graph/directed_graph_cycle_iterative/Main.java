/**
 * Compile: javac directed_graph_cycle_iterative/Main.java directed_graph_cycle_iterative/Node.java
 * Run: java directed_graph_cycle_iterative/Main
 */

package directed_graph_cycle_iterative;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        // Edge list
        // int[][] e = { {}, { 0, 3 }, { 0 }, { 1, 2 } };
        // int[][] e = {{1},{ 2, 3, 4, 5, 6, 7 },{},{ 2, 7 },{ 5 },{},{ 4 },{}};
        int[][] e = { { 8 }, { 0, 2 }, { 0, 3 }, { 0, 4 }, { 0, 5 }, { 0 }, { 7 }, { 8 }, { 6 } };

        boolean found = findCycle(e);
        System.out.println("\nFound: " + found);
    }

    static boolean findCycle(int[][] edges) {
        List<Node> graph = createAdjacencyList(edges);
        boolean status = dfsDirected(graph);
        return status;
    }

    static List<Node> createAdjacencyList(int[][] vertices) {

        int length;
        int id;
        List<Node> parents = new ArrayList<>();

        for (int i = 0; i < vertices.length; i++) {
            Node parent = new Node(i);
            parents.add(parent);

            length = vertices[i].length;
            for (int j = 0; j < length; j++) {
                id = vertices[i][j];
                Node node = new Node(id);
                parent.addChild(node);
            }
        }
        return parents;
    }

    static boolean dfsDirected(List<Node> adjlist) {

        Stack<Node> stack = new Stack<>();

        // beingExplored means node is on the stack
        boolean[] beingExplored = new boolean[adjlist.size()];

        for (int i = 0; i < adjlist.size(); i++) {
            Node startNode = adjlist.get(i);
            if (startNode.isExplored) {
                continue;
            }
            stack.push(startNode);

            while (!stack.isEmpty()) {
                Node node = stack.peek();

                if (!node.isExplored) {
                    node.isExplored = true;
                    beingExplored[node.id] = true;
                } else {
                    beingExplored[node.id] = false;
                    stack.pop();
                }

                for (Node n : adjlist.get(node.id).getChildren()) {
                    if (!n.isExplored) {
                        stack.push(n);
                    } else if (beingExplored[n.id] == true) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}