package create_graph;

import java.util.ArrayList;
import java.util.List;

public class Node {

    int data;
    boolean isVisited;
    List<Node> children;

    Node(int data) {
        this.data = data;
        this.isVisited = false;
        this.children = new ArrayList<>();
    }

    public void addChild(Node node) {
        this.children.add(node);
    }

    public List<Node> getChildren() {
        return this.children;
    }
}
