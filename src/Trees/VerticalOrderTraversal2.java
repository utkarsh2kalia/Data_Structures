package Trees;

import java.util.*;

class Pair{

    TreeNode node;
    int column;
    Pair(TreeNode node, int column)
    {
        this.node = node;
        this.column = column;

    }



}
public class VerticalOrderTraversal2 {

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList();
        if (root == null) {
            return output;
        }

        Map<Integer, ArrayList> columnTable = new HashMap();
        // Pair of node and its column offset
        Queue<Pair> queue = new ArrayDeque();
        int column = 0;
        queue.offer(new Pair(root, column));

        int minColumn = 0, maxColumn = 0;

        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            root = p.node;
            column = p.column;

            if (root != null) {
                if (!columnTable.containsKey(column)) {
                    columnTable.put(column, new ArrayList<Integer>());
                }
                columnTable.get(column).add(root.data);
                minColumn = Math.min(minColumn, column);
                maxColumn = Math.max(maxColumn, column);

                queue.offer(new Pair(root.left, column - 1));
                queue.offer(new Pair(root.right, column + 1));
            }
        }

        for(int i = minColumn; i < maxColumn + 1; ++i) {
            output.add(columnTable.get(i));
        }

        return output;
    }







}
