package Java;

import java.io.*;
import java.util.*;
public class BinaryNumbersWithoutConsecOnes {





        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter wr = new PrintWriter(System.out);
            int T = Integer.parseInt(br.readLine().trim());
            for(int t_i=0; t_i<T; t_i++)
            {
                int N = Integer.parseInt(br.readLine().trim());

                String out_ = CodeGenerator(N);
                System.out.println(out_);
            }

            wr.close();
            br.close();
        }
        static String CodeGenerator(int N){
            // Your code goes here
// String curr = "1";
// Spring prev ="9";
// int brr = 0;
// int c = 0,i=1;
// List<String> list = new ArrayList<>();
// Map<Integer, String> map = new HashMap<>();
// while(c<N)
// {
//     if(!Integer.toBinaryString(i).contains("11"))
//     {
//         c++;
//     }
//     i++;

// }
// list.add("0");
// list.add("1");
            Queue<String> qu = new LinkedList<String>();
            int c = 2;
// map.put(1,"1");
            qu.offer("1");
// System.out.println(map.get(1));
            for(int i = 2; c<=N;i++)
            {
                int size = qu.size();
                for(int j = 0; j<size; j++)
                {
                    // String ss = map.get(i-1);
                    String ss = qu.poll();
                    char[] ch = ss.toCharArray();
                    if(ch[ch.length-1]=='1')
                    {
                        qu.offer(ss+"0");
                        c++;

                    }
                    else
                    {
                        qu.offer(ss+"0");
                        c++;

                        qu.offer(ss+"1");
                        c++;
                        // c =c+2;
                    }
                    if(c>=N)
                        break;

                }

                // String ss = map.get(i-1);
                // map.remove(i-1);
                // char[] ch = ss.toCharArray();
                // if(ch[ch.length-1]=='1'
                // )
                // {
                //     map.put(c++,ss+"0");

                // }
                // else
                // {
                //     map.put(c++,ss+"0");

                //     map.put(c++,ss+"1");
                //     // c =c+2;
                // }

            }
// System.out.println(qu);
            return qu.poll()+"";

        }

}
