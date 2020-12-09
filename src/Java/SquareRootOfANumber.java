package Java;

public class SquareRootOfANumber {
    public static double squareRoot(int num){
        int root = num/ 2;
        double t = 0.1;
        double r;
        while ( Math.abs((root - (num/ root) )) > t ) {
            r = 0.5 * (root + (num/ root));
        }
        return root;
    }

    public static void main(String[] args) {
        System.out.println(squareRoot(25));;
    }
//    Read more: https://javarevisited.blogspot.com/2011/08/code-comments-java-best-practices.html#ixzz6bJB5nSPX
}
