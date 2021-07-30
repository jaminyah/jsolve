/**
 * Creates a graph given a set of edges.
 */

package create_graph;

import java.util.ArrayList;
import java.util.List;

class Main {

    public static void main(String[] args) {
        int[][] edges = {{1, 3}, {2, 3, 4}, {0}, {}, {2, 5}, {}};

        List<Node> parents = createGraph(edges);

        // Display parents and children
        List<Node> childern = new ArrayList<>();
        for (Node parent: parents) {
            childern = parent.getChildren();
            for (Node child: childern) {
                System.out.println("Parent: " + parent.data + " Child: " + child.data);
            }

        }
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
}