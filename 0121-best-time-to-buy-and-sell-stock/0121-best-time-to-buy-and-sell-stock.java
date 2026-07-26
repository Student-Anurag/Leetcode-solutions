class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int prevSmallStockPrice = prices[0], profit = 0;
        for(int i=1; i<n; i++) {
            if(prices[i] > prevSmallStockPrice) {
                profit = Math.max(profit, prices[i] - prevSmallStockPrice);
            }
            else prevSmallStockPrice = prices[i];
        }
        return profit;
    }
}