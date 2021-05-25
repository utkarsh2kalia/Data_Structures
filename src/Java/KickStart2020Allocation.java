import java.io.*;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class KickStart2020Allocation {

    public static void main(String[] args)throws IOException {
        Scanner sc = new Scanner(System.in);
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // StringTokenizer st;
        int t = sc.nextInt();
//        br.readLine();
//        System.out.println(t);
        int cc = 0;
        while(cc++!=t){

            int n = sc.nextInt();
            int bg = sc.nextInt();
            int nums[]  = new int[n];
            int max = Integer.MIN_VALUE;
            for(int i =0; i<n; i++)
            {nums[i]= sc.nextInt();
                max = Integer.max(max, nums[i]);

            }
            int[] aux = new int[max+1];
            // map th frequencies
            for(int i =0; i<n; i++)
            {
                aux[nums[i]]++;
            }
            int result = 0;
            for(int i = 1; i<aux.length && bg>0; i++){

                if(aux[i]<=0)
                    continue;
                if(bg - i*aux[i] >=0)
                {
                    bg = bg - i*aux[i];
                    result+=aux[i];
                }
                else
                {
                    while(aux[i]-->0){
                        bg = bg - i;
                        if(bg<0)
                            break;
                        result++;

                    }
                }

            }


            System.out.println("Case #"+ cc+": "+result);

        }


    }
}
