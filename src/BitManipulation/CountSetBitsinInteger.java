package BitManipulation;

public class CountSetBitsinInteger {
    public static int countsetbits(int n){
        int count = 0;
        while(n!=0){
            count += (n & 1);// check if last bit is 1
            n >>= 1; // move bits to right
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 16;
        System.out.println(n+" in binary is "+ Integer.toBinaryString(n));
//        System.out.println(n-1+" in binary is "+ Integer.toBinaryString(n&(n-1)));
        System.out.println("The number of set bits in "+n+ " is " +countsetbits(n));
    }
}
