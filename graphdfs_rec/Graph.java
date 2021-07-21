package graphdfs_rec;

import java.util.List;

class Graph {

    // DFS using recursion
    public void dfs(Node node) {

        System.out.print(node.data + ", ");

        List<Node> children = node.getChildren();
        node.isVisited = true;

        for (Node child: children) {
            if (child != null && (child.isVisited == false)) {
                dfs(child);
            }
        }
    }
}