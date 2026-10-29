class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int len = 0;                                     // tails 中有效元素的个数

        for (int x : nums) {
            // 在 tails[0..len-1] 中二分查找第一个 >= x 的位置
            int lo = 0, hi = len;
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                if (tails[mid] < x) lo = mid + 1;
                else hi = mid;
            }
            tails[lo] = x;                               // 替换，或者 lo == len 时相当于追加
            if (lo == len) len++;
        }
        return len;
    }
}