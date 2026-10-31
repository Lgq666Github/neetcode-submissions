class Solution {
    public int maxProfit(int[] prices) {
        int hold = -prices[0], sold = 0, rest = 0;
        for (int i = 1; i < prices.length; i++) {
            int p = prices[i];
            int prevHold = hold, prevSold = sold, prevRest = rest;
            hold = Math.max(prevHold, prevRest - p);
            sold = prevHold + p;
            rest = Math.max(prevRest, prevSold);
        }
        return Math.max(sold, rest);
    }
}
