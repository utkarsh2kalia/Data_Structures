package Matrix;


import java.util.*;
//https://leetcode.com/problems/diagonal-traverse/
//Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order as shown in the below image.
//Example:
//Input:
//[
// [ 1, 2, 3 ],
// [ 4, 5, 6 ],
// [ 7, 8, 9 ]
//]
//Output:  [1,2,4,7,5,3,6,8,9]
public class DiagonalTraverse {


            public static int[] findDiagonalOrder(int[][] mat)
            {

                int direction = 1; // 1-> up, 0-> down
                int i = 0, j = 0, k = 0;
                int[] res = new int[mat.length * mat[0].length];

                while(i < mat.length && j < mat[0].length)
                {

                    if(direction == 1)
                    {
                        //int r = i, c = j;
                        while(i >= 0 && j < mat[0].length)
                        {
                            res[k] = mat[i][j];
                            i = i-1;
                            j = j+1;
                            k++;
                        }
                        //j = c+1;
                        i++;
                        if(j >= mat[0].length)
                        {
                            i = i+1;
                            j = j-1;
                        }
                        direction = 1-direction;
                    }
                    else
                        {
                        //int r = i, c = j;
                        while(i < mat.length && j >= 0){
                            res[k] = mat[i][j];
                            i = i+1;
                            j = j-1;
                            k++;
                        }
                        j++;
                        if(i >= mat.length){
                            j = j+1;
                            i = i-1;
                        }
                        direction = 1-direction;
                        }
                }
                return res;

            }




    public static void main(String[] args)
    {

        int [][]matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        DiagonalTraverse diagonalTraverse = new DiagonalTraverse();
        System.out.println((Arrays.toString(diagonalTraverse.findDiagonalOrder(matrix))));


            }







}
