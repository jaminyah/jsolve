package graphdfs_node;

import java.util.ArrayList;
import java.util.List;

class Node {

    String name;
    boolean isVisited;
    List<Node> children = new ArrayList<>();

    Node(String name) {
        this.name = name;
        this.isVisited = false;
    }

    public List<String> depthFirstSearch(List<String> array) {

        // System.out.print("\ndepthFirstSearch - " + name + " ");
        array.add(name);

        isVisited = true;
        // System.out.println("\nchildNodes.size() - " + children.size());

        for (int i = 0; i < children.size(); i++) {

            Node child = children.get(i);
            // System.out.print("\nNode: " + name + " - " + "child: " + child.name);

            if ( child != null && !child.isVisited) {
                // System.out.println("child - " + child.name);
                array = child.depthFirstSearch(array);
            }
        }
        return array;
    }

    public Node addChild(String name) {

        Node child = new Node(name);
        // System.out.println(this.name + " addChild - " + child.name);       
        children.add(child);

        return this;
    }

    public List<Node> getChildren() {
        return children;
    }
}