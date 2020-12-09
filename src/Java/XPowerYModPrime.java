package Java;

public class XPowerYModPrime {
    static int power(int x, int y, int p) {

        // Initialize result
        int res = 1;

        // Update x if it is more
        // than or equal to p
        x = x % p;

        while (y > 0) {

            // If y is odd, multiply x with result
            if (y % 2 != 0)
                res = (res * x) % p;

            // y must be even now
            y = y >> 1; // y = y/2
            x = (x * x) % p;
        }
        return res;
    }

    public static void main(String[] args) {
        int X = 5, Y = 9, P = 4, M = 19;

        System.out.print(power(37, 43, 77));
    }
}
