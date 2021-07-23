package graphdfs_stack;

import java.util.List;
import java.util.Stack;

class Graph {

    // Iterative DFS using stack
    public void dfsStack(Node startNode) {
        Stack<Node> stack = new Stack<Node>();
        stack.add(startNode);

        while (stack.isEmpty() == false) {
            Node topNode = stack.pop();

            if (topNode.isVisited == false) {
                System.out.print(topNode.data + " ");
                topNode.isVisited = true;
            }

            List<Node> childNodes = topNode.getChildren();

            for (Node child : childNodes) {
                if (child != null && child.isVisited == false) {
                    stack.add(child);
                }
            }
        }
    }
}