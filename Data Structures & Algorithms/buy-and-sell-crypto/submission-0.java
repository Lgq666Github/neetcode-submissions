class Solution {
    public int maxProfit1(int[] prices) {
        int l = 0, r = 1;
        int maxP = 0;
        while (r < prices.length) {
            if (prices[l] < prices[r]) {
                int profit = prices[r] - prices[l];
                maxP = Math.max(maxP, profit);
            } else {
                l = r; // 如果卖出价格低于买入价格，移动左指针到当前的卖出位置
            }
            r++;
        }
        return maxP;
    }

    public int maxProfit(int[] prices) {
        int maxP = 0;
        int minBuy = prices[0];
        for (int sell : prices) {
            maxP = Math.max(maxP, sell - minBuy);
            minBuy = Math.min(minBuy, sell);
        }
        return maxP;
    }
}
