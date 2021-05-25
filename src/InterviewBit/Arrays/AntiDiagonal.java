package InterviewBit.Arrays;

public class AntiDiagonal {
//    Give a N*N square matrix, return an array of its anti-diagonals. Look at the example for more details.

    public int[][] diagonal(int[][] mat) {

        int i = 0, j = 0, k = 0,l=0;
        int[][] res = new int[mat.length][mat.length];


        while(i < mat.length && j < mat[0].length){
            while(i < mat.length && j >= 0){
                res[l][k] = mat[i][j];
                i = i+1;
                j = j-1;
                k++;
            }

            if(i >= mat.length){
                i = j+2;;
                j = mat[0].length-1;
            }
            else
            {
                // System.out.println(i+" "+j);
                j = i;
                i = 0;
            }
            ++l;

        }

        return res;




    }
}
