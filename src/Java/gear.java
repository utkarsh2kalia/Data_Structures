package Java;

import java.util.Scanner;

public class gear {

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int r1 = sc.nextInt();
        int r2 = sc.nextInt();
        int r3 = sc.nextInt();
        int rot1 = sc.nextInt();
        int rot3 = (int)((r1*1.0/r3)*rot1);
        System.out.print(rot3);
    }
}
