package Matrix;
import java.util.Arrays;
public class LongestIncreasingPathInMatrix {
    public static final int [][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0} };
    private int m,n;
    public int longestIncreasingPath(int[][] matrix) {

        if(matrix.length == 0)
            return 0;
        m = matrix.length;
        n = matrix[0].length;
        int cache[][] = new int[m][n];

        int ans = 0;
        for(int i =0; i<m; i++)
        {
            for(int j= 0; j<n; j++)
            {
                ans = Math.max(ans, dfs(matrix, i, j, cache));

            }
        }
        System.out.print(Arrays.deepToString(cache));
        return ans;


    }
    public int dfs(int matrix[][], int i, int j, int cache[][])
    {
        if(cache[i][j]!=0)
            return cache[i][j];

        for(int dir[]: dirs)
        {
            int x = i + dir[0];
            int y = j + dir[1];

            if(x<m && x>=0 && y<n && y>=0 && matrix[x][y] > matrix[i][j])
            {
                cache[i][j] = Math.max(cache[i][j], dfs(matrix, x, y, cache));
            }
        }
        return ++cache[i][j];

    }

    public static void main(String[] args) {
        LongestIncreasingPathInMatrix obj = new LongestIncreasingPathInMatrix();
        int [][]nums =
                {
                        {9, 9, 4},
                        {6, 6, 8},
        {2, 1, 1}
        };


        System.out.println(obj.longestIncreasingPath(nums));
    }

}
