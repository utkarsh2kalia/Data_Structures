package Matrix;
//Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
//
//Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)
//
//Example 1:
//
//[[0,0,1,0,0,0,0,1,0,0,0,0,0],
// [0,0,0,0,0,0,0,1,1,1,0,0,0],
// [0,1,1,0,1,0,0,0,0,0,0,0,0],
// [0,1,0,0,1,1,0,0,1,0,1,0,0],
// [0,1,0,0,1,1,0,0,1,1,1,0,0],
// [0,0,0,0,0,0,0,0,0,0,1,0,0],
// [0,0,0,0,0,0,0,1,1,1,0,0,0],
// [0,0,0,0,0,0,0,1,1,0,0,0,0]]
//Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
public class MaxAreaOfIsland {
    public int dfs(int i, int j, int[][] grid, int count)
    {
        if(i<0 || j<0 || i>=grid.length || j>= grid[0].length || grid[i][j] == 0)
        {

            return count;
        }

        grid[i][j] = 0;
        count++;

        count = dfs(i+1, j, grid, count);
        count = dfs(i-1, j, grid, count);
        count = dfs(i, j+1, grid, count);
        count = dfs(i, j-1, grid, count);

        return count;
        // alternatively(return 1 + dfs(i+1...)+dfs(i-1)..... and return 0 in if block, no need of count++
    }

    public int maxAreaOfIsland(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        int max = 0;
        for(int i =0; i<n; i++)
        {
            for(int j = 0; j<m;j++)
            {

                if(grid[i][j] ==1)
                {

                    max = Math.max(max, dfs(i, j, grid, 0));
                }


            }
        }

        return max;


    }

    public static void main(String[] args) {
        int arr[][] = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,1,1,0,1,0,0,0,0,0,0,0,0},
                        {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        MaxAreaOfIsland obj = new MaxAreaOfIsland();
        System.out.println(obj.maxAreaOfIsland(arr));

}



}
