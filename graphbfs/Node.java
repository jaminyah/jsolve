package graphbfs;

import java.util.List;
import java.util.ArrayList;

class Node {
    int data;
    boolean isVisited;
    List<Node> children;

    Node(int data) {
        this.data = data;
        this.isVisited = false;
        this.children = new ArrayList<>();
    }

    public void addChild(Node child) {
        this.children.add(child);
    }

    public List<Node> getChildren() {
        return this.children;
    }
}