package Trees;

import com.sun.source.tree.Tree;
import org.w3c.dom.Node;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static Trees.InorderTraversal.inordertraversal;
import static Trees.InorderTraversal.maketree;

//Serialization and deserialization is used to store and retrieve a tree from a file.
public class SerializeAndDeserializeATree {
    public static String serialize(TreeNode root){
        StringBuilder str = new StringBuilder();
        return serializer(str, root).toString();
    }
    public static TreeNode deserialze(String str){
        return deserializer(new LinkedList<>(Arrays.asList(str.split(","))));
    }

    public static StringBuilder serializer(StringBuilder str, TreeNode root){
        // check if the root is null
        if(root == null)
            return str.append("#");
        str.append(root.data).append(",");
        serializer(str, root.left).append(",");
        serializer(str, root.right);
        return str;
    }
    public static TreeNode deserializer(Queue<String> q)
    {
        String s = q.poll();
        if(s.equalsIgnoreCase("#"))
            return null;
        TreeNode root = new TreeNode(Integer.valueOf(s));
        root.left = deserializer(q);
        root.right = deserializer(q);
        return root;

    }

    public static void main(String[] args) {
        int arr[] = {2,3,34,43,5,43,32,21,3,313,3};
        String s = serialize(maketree(arr));
        System.out.println(s);
        inordertraversal(deserialze(s));

    }

}
