package Trees;

import java.util.ArrayList;
import java.util.List;
//(1) the traverse of the tree is NOT standard pre-order traverse. It checks the RIGHT node first and then the LEFT
//(2) the line to check currDepth == result.size() makes sure the first element of that level will be added to the result list
//(3) if reverse the visit order, that is first LEFT and then RIGHT, it will return the left view of the tree.


public class RightViewOfBinaryTree {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightView(root, result, 0);
        return result;
    }

    public void rightView(TreeNode curr, List<Integer> result, int currDepth){
        if(curr == null){
            return;
        }
        if(currDepth == result.size()){
            result.add(curr.data);
        }

        rightView(curr.right, result, currDepth + 1);
        rightView(curr.left, result, currDepth + 1);

    }
}
