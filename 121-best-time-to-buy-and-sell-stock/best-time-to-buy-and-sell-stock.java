import java.lang.Integer;
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = prices[0];
        int diff;
        for (int i = 1; i < prices.length; i++) {
            diff = prices[i] - minPrice;
            if (diff > maxProfit) {
                maxProfit = diff;
            }
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
        }
        return maxProfit;
    }
}