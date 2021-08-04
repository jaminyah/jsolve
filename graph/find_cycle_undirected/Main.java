/**
 * Find cycle in a undirected graph
 */

package find_cycle_undirected;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Main {
    public static void main(String[] args) {

        int[][] e = { { 1, 3 }, { 2, 3, 4 }, { 0 }, {}, { 2, 5 }, {} };
        boolean found = findCycle(e);
        System.out.println("Found: " + found);
    }

    static boolean findCycle(int[][] edges) {

        List<Node> parents = createGraph(edges);
        boolean status = traverseDFS(parents);
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

    static boolean traverseDFS(List<Node> graph) {

        List<Node> visitedList = new ArrayList<>();
        Stack<Node> stack = new Stack<Node>();
        Node topNode;

        Node startNode = graph.get(0);
        stack.add(startNode);

        while (stack.isEmpty() == false) {
            topNode = stack.pop();
            System.out.println("topNode: " + topNode.data);

            if (topNode.isVisited == false) {
                System.out.println(topNode.data + ", ");
                topNode.isVisited = true;
                visitedList.add(topNode);
            }

            List<Node> childNodes = graph.get(topNode.data).getChildren();
            System.out.println("Size: " + childNodes.size());
            for (Node child : childNodes) {

                System.out.println("Parent: " + topNode.data + " child: " + child.data + " - contains child: "
                        + visitedList.contains(child));

                if (visitedList.contains(child)) {
                    System.out.println("Visited list contains: " + child.data);
                    return true;
                }

                if (child != null && child.isVisited == false) {
                    System.out.println("Stack add child: " + child.data);
                    stack.add(child);
                }
            }
        }
        return false;
    }
}
