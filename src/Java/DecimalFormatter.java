package Java;

import java.text.DecimalFormat;

public class DecimalFormatter {
    public static void decimalfromatter(double n, int precision){
        DecimalFormat ff = new DecimalFormat();
        ff.setMaximumFractionDigits(precision);
        System.out.println(ff.format(n));

    }

    public static void main(String[] args) {
        double n = 234444.463783;
        decimalfromatter(n, 4 );
    }
}
