class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for (int x : nums) total += x;
        if (Math.abs(target) > total || (total + target) % 2 != 0) return 0;

        int p = (total + target) / 2;
        int[] dp = new int[p + 1];
        dp[0] = 1;                                       // 和为 0 的子集：空集，一种
        for (int x : nums) {
            for (int s = p; s >= x; s--) {               // 倒序：每个数字只用一次
                dp[s] += dp[s - x];
            }
        }
        return dp[p];
    }
}