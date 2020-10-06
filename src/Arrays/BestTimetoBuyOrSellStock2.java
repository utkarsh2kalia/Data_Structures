package Arrays;

public class BestTimetoBuyOrSellStock2 {
    public  static int  maxProfit2(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }


    public static void main(String[] args) {
        int prices[] ={7,1,5,3,6,4};
        System.out.println(maxProfit2(prices));
    }
}
