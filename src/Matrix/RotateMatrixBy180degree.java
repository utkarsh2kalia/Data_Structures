package Matrix;

import java.util.Arrays;

public class RotateMatrixBy180degree {

    public static int[][] rotateMatrix(int arr[][]){

        int n= arr.length;
        int m = arr[0].length;
        // swap n/2 rows with the last n/2 rows(0,0) by (n-1, n-1)
        for(int i =0; i<n/2; i++){

            for(int j = 0; j<m; j++){

                int temp = arr[i][j];
                arr[i][j] = arr[n - i - 1][n - j - 1];
                arr[n - i - 1][n - j - 1] = temp;
            }
        }

        // in case the rows are odd, we need to rotate the row without in its positions
        if(n %2 == 1){

            for(int j = 0; j<m/2; j++)
            {
                int temp = arr[n/2][j];
                arr[n/2][j] = arr[n/2][n - j - 1];
                arr[n/2][n - j - 1] = temp;
            }

        }




        return arr;


    }


    public static void main(String[] args) {
        int [][]arr = { { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 } };

        System.out.println(Arrays.deepToString(rotateMatrix(arr)));


    }
}
