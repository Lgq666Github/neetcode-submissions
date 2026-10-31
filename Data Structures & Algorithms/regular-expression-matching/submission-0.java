class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        // 第 0 行：空串只能被 x* x* ... 这样的模式匹配
        for (int j = 2; j <= n; j++) {
            if (p.charAt(j - 1) == '*') dp[0][j] = dp[0][j - 2];
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char pc = p.charAt(j - 1);
                if (pc == '*') {
                    char prev = p.charAt(j - 2);                         // x* 中的 x
                    dp[i][j] = dp[i][j - 2]                              // 匹配零个
                            || (matches(s.charAt(i - 1), prev) && dp[i - 1][j]);  // 匹配一个，保留 x*
                } else {
                    dp[i][j] = matches(s.charAt(i - 1), pc) && dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }

    private boolean matches(char c, char x) {
        return x == '.' || x == c;
    }
}