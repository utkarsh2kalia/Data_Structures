package Java;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class alphabetfreq {
    public static String freq(String s){
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0; i<s.length()-1; i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            }
            else
                {
                    map.put(ch,1);
                }

            }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(Map.Entry<Character,Integer> i: map.entrySet() ){
            if(max<i.getValue()){
                max = i.getValue();
            }
            if(min>i.getValue()){
                min = i.getValue();
            }
        }

        int diff = max - min;
        char dir = s.charAt(s.length()-1);
        String cord = "";
        if(dir == 's'){
            cord = "South";
        }
        else if(dir == 'w') {
            cord = "West";
        }
        else if(dir == 'n'){
            cord = "North";
        }
        else if(dir == 'e'){
            cord = "East";
        }
        return (diff+" "+cord);
        }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String lat = sc.nextLine();
        String longi = sc.nextLine();
        System.out.print(freq(lat)+" "+freq(longi));

    }
}
