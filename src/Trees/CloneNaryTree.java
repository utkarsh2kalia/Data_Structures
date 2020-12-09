package Trees;

import org.w3c.dom.Node;

import java.util.List;
// Given a root of an N-ary tree, return a deep copy (clone) of the tree.
//
//        Each node in the n-ary tree contains a val (int) and a list (List[Node]) of its children.

import java.util.List;

class Node3 {
    public int val;
    public List<Node3> children;
    Node3(int val)
    {
        this.val = val;
    }
}
//Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).
public class CloneNaryTree {
    public Node3 cloneTree(Node3 root) {
        if (root == null)
            return null;
        Node3 clonednode = new Node3(root.val);
        for(Node3 child: root.children){
            clonednode.children.add(cloneTree(child));
        }
        return clonednode;

    }

}
