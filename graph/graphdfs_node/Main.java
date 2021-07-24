package graphdfs_node;

import java.util.List;
import java.util.ArrayList;

class Main {

    public static void main(String arg[]) {
 
        Node nodeA = new Node("A");
        nodeA = nodeA.addChild("B");
        nodeA = nodeA.addChild("C");
        nodeA = nodeA.addChild("D");

        Node nodeB = nodeA.children.get(0);
        // Node nodeC = nodeA.children.get(1);
        Node nodeD = nodeA.children.get(2);

        nodeB.addChild("E");
        nodeB.addChild("F");

        nodeD.addChild("G");
        nodeD.addChild("H");

        Node nodeF = nodeB.children.get(1);
        nodeF.addChild("I");
        nodeF.addChild("J");

        Node nodeG = nodeD.children.get(0);
        nodeG.addChild("K");

        System.out.println("\n---- DFS node traversal ----");
        List<String> dfslist = new ArrayList<>();
        dfslist = nodeA.depthFirstSearch(dfslist);
        
        System.out.println(dfslist);
    }
}