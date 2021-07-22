package graphbfs_node;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Queue;
import java.util.List;

class Node {

    String name;
    boolean isVisited;
    List<Node> children = new ArrayList<>();

    Node(String name) {
        this.name = name;
        this.isVisited = false;
    }

    public List<String> breadthFirstSearch(List<String> array) {

        Queue<Node> queue = new LinkedList<>();
        Node firstNode;

        isVisited = true;
        queue.add(this);

        while(queue.isEmpty() == false) {
            firstNode = queue.remove();
            array.add(firstNode.name);

            List<Node> childNodes = firstNode.getChildren();

            for (Node child: childNodes) {
                if (child != null && (child.isVisited == false)) {
                    child.isVisited = true;
                    queue.add(child);
                }
            }
        }
    
        return array;
    }

    public Node addChild(String name) {

        Node child = new Node(name); 
        children.add(child);
        return this;
    }

    public List<Node> getChildren() {
        return children;
    }
}