package Matrix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//Give a N*N square matrix, return an array of its anti-diagonals. Look at the example for more details.
//
//Example:
//
//
//Input:
//
//1 2 3
//4 5 6
//7 8 9
//
//Return the following :
//
//[
//  [1],
//  [2, 4],
//  [3, 5, 7],
//  [6, 8],
//  [9]
//]
public class AntiDiagonals {
    public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {


        Map<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int i=0; i<A.size(); i++) {
            for (int j=0; j<A.get(i).size(); j++) {
                ArrayList<Integer> arrayList;
                if (map.containsKey(i+j)) {
                    arrayList = map.get(i+j);
                }
                else {
                    arrayList = new ArrayList<>();
                }

                arrayList.add(A.get(i).get(j));
                map.put(i+j, arrayList);
            }
        }

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for (int key : map.keySet()) {
            ans.add(map.get(key));
        }

        return ans;
    }


    public int[] findDiagonalOrder(int[][] mat) {

        int direction = 1; // 1-> up, 0-> down
        int i = 0, j = 0, k = 0;
        int[] res = new int[mat.length * mat[0].length];

        while(i < mat.length && j < mat[0].length){
            while(i < mat.length && j >= 0){
                res[k] = mat[i][j];
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
                System.out.println(i+" "+j);
                j = i;
                i = 0;
            }

        }

        return res;

    }

    public static void main(String[] args) {

    }
}
