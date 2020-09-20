package Matrix;
import java.util.Arrays;
public class RotateMatrixby90degree {
    public static void rotatematrixby90clockwise(int matrix[][]){
        // find the transpose of the matrix
        int n = matrix.length;
        for (int i = 0; i < n; i++){
            for(int j = 0; j<i; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // swap columns  (for clockwise)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n/2; j++) {
                // swap matrix[i][j] with matrix[n-i-1][j]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j -1] = temp;
            }
        }


    }

    public static void rotatematrixby90anticlockwise(int matrix[][]){
        // find the transpose of the matrix
        int n = matrix.length;
        for (int i = 0; i < n; i++){
            for(int j = 0; j<i; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // swap rows  (for clockwise)
        for (int i = 0; i < n/2; i++) {
            for (int j = 0; j < n; j++) {
                // swap matrix[i][j] with matrix[n-i-1][j]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = temp;
            }
        }


    }
    public static void printmatrix(int matrix[][]){
        for (var r: matrix) {
            System.out.println(Arrays.toString(r));
        }
    }

    public static void main(String[] args) {
        int[][] matrix =
                {
                        { 1, 2, 3, 4 },
                        { 5, 6, 7, 8 },
                        { 9, 10, 11, 12 },
                        { 13, 14, 15, 16 }
                };
       // rotatematrixby90clockwise(matrix);
        rotatematrixby90anticlockwise(matrix);
        printmatrix(matrix);

    }
}
