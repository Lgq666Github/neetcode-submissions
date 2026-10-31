class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        for (int i = 0; i <= n; i++) dp[i][0] = 1;       // 凑出 0 元：一种方式

        for (int i = 1; i <= n; i++) {
            int c = coins[i - 1];
            for (int a = 1; a <= amount; a++) {
                dp[i][a] = dp[i - 1][a];                  // 不用第 i 种
                if (a >= c) dp[i][a] += dp[i][a - c];     // 至少用一枚第 i 种（同一行）
            }
        }
        return dp[n][amount];
    }
}