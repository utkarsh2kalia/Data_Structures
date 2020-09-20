package Matrix;

import java.util.ArrayList;
import java.util.List;

// traverse the matrix in spiral order, first around the corners then inwards
public class SpiralOrderMatrixTraversal {

    public static List<Integer> printspiralmatrix1(int matrix[][]) {
        // have four variables signifying c1, r1, c2, r2
        // these mark the first and the last rows and columns

        List<Integer> ans = new ArrayList<>();
        int c1 = 0, r1 = 0, c2 = matrix[0].length - 1, r2 = matrix.length - 1;
        while( r1 <= r2 && c1 <= c2){
            for(int c = c1; c <= c2; c++) ans.add(matrix[r1][c]);
            for(int r = r1 + 1; r <= r2; r++) ans.add(matrix[r][c2]);
            if(r1 < r2 && c1 < c2){
                for(int c = c2 - 1; c > c1; c--) ans.add(matrix[r2][c]);
                for(int r = r2 - 1; r > r1; r--) ans.add(matrix[r][c1]);
            }
            r1++;
            c1++;
            r2--;
            c2--;


        }
        return ans;






    }
    public static void main(String[] args)
    {
        int matrix[][] = {{1,1,1,1,1,1}, {1,2,2,2,2,1}, {1,2,3,3,2,1}, {1,2,2,2,2,1}, {1,1,1,1,1,1}};
        System.out.println(printspiralmatrix1(matrix));
    }
}
