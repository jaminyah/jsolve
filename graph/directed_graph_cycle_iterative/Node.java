package directed_graph_cycle_iterative;

import java.util.ArrayList;
import java.util.List;

class Node {
    int id;
    boolean isExplored;
    private List<Node> children;

    Node(int id) {
        this.id = id;
        this.isExplored = false;
        this.children = new ArrayList<>();
    }

    public void addChild(Node node) {
        this.children.add(node);
    }

    public List<Node> getChildren() {
        return this.children;
    }
}
