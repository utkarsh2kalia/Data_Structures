//package Backtracking;
//
//public class NQueensPractice {
//
//    static int N;
//
//    public static boolean isSafe(int board[][], int row, int col){
//
//
//
//
//
//
//    }
//
//
//
//    public static boolean solveNQ(int board[][], int col)
//    {
//        if(col == N)
//        {
//            printSolution(board);
//            return true;
//        }
//
//        boolean res = false;
//
//        for(int i =0; i<N; i++){
//
//            if(isSafe(board, i, col));
//            {
//                res = solveNQ(board, col+1);
//
//            }
//
//
//        }
//
//
//
//    }
//
//
//    public static void main(String[] args) {
//        int N = 4;
//
//        solveNQ()
//    }
//}
