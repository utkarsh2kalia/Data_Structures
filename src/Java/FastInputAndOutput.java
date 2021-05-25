package Java;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

import static java.util.Arrays.asList;

// Using BufferedReader and StringTokenizer
public class FastInputAndOutput {

    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        list.addAll(asList(new Integer [] {1,2,3,4,5}));
        Integer arr[] = new Integer[5];
         list.toArray(arr);

//        System.out.println(list.stream().toArray(Integer[] :: new)[0]);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        bw.write("hello");
        OutputStream out = new BufferedOutputStream ( System.out );
        while (st.hasMoreTokens()) {
            String ss = st.nextToken();
            out.write((ss+"hello").getBytes());


        }
        out.flush();




    }




}

