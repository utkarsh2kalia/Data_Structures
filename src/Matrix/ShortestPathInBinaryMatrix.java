package Matrix;

import java.util.ArrayDeque;
import java.util.Queue;
//Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.
//
//A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:
//
//All the visited cells of the path are 0.
//All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
//The length of a clear path is the number of visited cells of this path.

//Input: grid = [[0,1],[1,0]]
//Output: 2
//Example 2:

//Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
//Output: 4
public class ShortestPathInBinaryMatrix {


    public int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;
        // Below are 8 directions can cell go
        int[][] dirs = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}, {1,1}, {-1,1}, {1,-1}, {-1,-1}};

        if(grid == null || grid.length == 0) return -1;

        if(grid[0][0] != 0) return -1;

        Queue<int[]> qu = new ArrayDeque<int[]>();
        qu.offer(new int[]{0, 0});

        int step = 0;

        while(!qu.isEmpty()){
            int size = qu.size();


            // this loop is necessary to process all the elements in queue at once, so that
            // each step is move only once
            for(int i =0; i<size; i++)
            {
                int curr[] = qu.poll();
                if(curr[0] == n-1 && curr[1] ==n-1)
                    return step+1;

                for(int []dir: dirs){

                    int x = dir[0] + curr[0];
                    int y = dir[1] + curr[1];

                    if(x < 0 || y < 0 || x >= n || y >= n || grid[x][y] == 1) continue;
                    qu.add(new int[]{x, y});

                    grid[x][y] = 1;

                }
            }

            step++;


        }

        return -1;

    }
}
