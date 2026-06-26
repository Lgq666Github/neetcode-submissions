class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int maxCount = 0, l = 0, res = 0;
        // 统计每个字符出现次数
        for (int r = 0; r < s.length(); r++) {
            freq[s.charAt(r) - 'A']++;
            maxCount = Math.max(maxCount, freq[s.charAt(r) - 'A']);
            // 当滑动窗口大小减去窗口内最多出现的字符数量大于k时，需要缩小窗口
            while ((r - l + 1) - maxCount > k) {
                freq[s.charAt(l) - 'A']--;
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
