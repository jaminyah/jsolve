package graphbfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.List;

class Graph {

    public void bfs(Node node) {
        Queue<Node> queue = new LinkedList<>();

        node.isVisited = true;
        queue.add(node);

        while (queue.isEmpty() == false) {
            Node firstNode = queue.remove();
            System.out.print(firstNode.data + ", ");

            List<Node> childNodes = firstNode.getChildren();

            for (Node child : childNodes) {
                if (child != null && (child.isVisited == false)) {
                    child.isVisited = true;
                    queue.add(child);
                }
            }
        }
    }
}