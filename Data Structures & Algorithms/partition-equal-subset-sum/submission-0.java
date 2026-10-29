class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int x : nums) total += x;
        if (total % 2 != 0) return false;
        int target = total / 2;

        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int x : nums) {
            if (x > target) return false;                // 单个元素超过一半，不可能平分
            for (int s = target; s >= x; s--) {          // 倒序：每个元素只用一次
                dp[s] = dp[s] || dp[s - x];
            }
            if (dp[target]) return true;                 // 提前结束
        }
        return dp[target];
    }
}