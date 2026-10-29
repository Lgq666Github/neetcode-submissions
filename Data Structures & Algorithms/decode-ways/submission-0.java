class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;                                   // 空串：一种方法
        dp[1] = s.charAt(0) != '0' ? 1 : 0;

        for (int i = 2; i <= n; i++) {
            char one = s.charAt(i - 1);
            int two = (s.charAt(i - 2) - '0') * 10 + (one - '0');
            if (one != '0') dp[i] += dp[i - 1];              // 吃 1 个数字
            if (two >= 10 && two <= 26) dp[i] += dp[i - 2];  // 吃 2 个数字
        }
        return dp[n];
    }
}