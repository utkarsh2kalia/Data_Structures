package BitManipulation;

// hamming distance is the number of positions at which the corresponding bits are different
public class HammingDistance {

    public static int hammingdistance(int x, int y){
        return Integer.bitCount(x^y);
    }

    public static void main(String[] args) {
        System.out.println("Hamming distance between 1200 and 2000 is "+hammingdistance(1200, 2000));
    }
}
