package Backtracking;

public class NQueenAllSolutions {



        final int N = 8;
        public boolean isSafe(int board[][], int row, int col)
        {
            // check the row on the left side
            for(int i = 0; i<col; i++)
            {
                if(board[row][i] == 1)
                    return false;
            }
            // check upper left diagonal
            for(int i = row, j = col; i>=0 && j>=0; i--,j--)
            {
                if(board[i][j] == 1)
                    return false;
            }
            for(int i = row, j = col; i<N && j>=0; i++,j--)
            {
                if(board[i][j] == 1)
                    return false;
            }
            return true;
        }
        public boolean solveUtil(int board[][], int col)
        {
            if(col == N) {
                printsoln(board);
                return true;
            }
            boolean res = false;
            for(int i = 0; i<board.length; i++)
            {
            /* Check if queen can be placed on
        board[i][col] */
                if(isSafe(board, i, col))
                {
                    /* Place this queen in board[i][col] */
                    board[i][col] = 1;
                /* If placing queen in board[i][col]
                   doesn't lead to a solution then
                   remove queen from board[i][col] */
                    res = solveUtil(board, col+1) == true || res;

                    // else backtrack
                    board[i][col] = 0;
                }
            }
            return false;
        }
        public void printsoln(int board[][])
        {
            for(int i =0; i<N; i++)
            {
                for(int j = 0; j<N; j++ )
                    System.out.print(board[i][j]+" ");
                System.out.println();
            }
            System.out.println();
        }

        public static void main(String[] args) {
            int board[][] = {{0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}};
            NQueenAllSolutions obj = new NQueenAllSolutions();
            obj.solveUtil(board, 0);
//        obj.printsoln(board);
        }


    }


