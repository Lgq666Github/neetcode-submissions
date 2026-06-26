public class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26]; // 记录窗口内每个字母的出现次数
        int maxCount = 0; // 记录窗口内最多出现的字符次数
        int l = 0, res = 0;

        for (int r = 0; r < s.length(); r++) {
            freq[s.charAt(r) - 'A']++; // 统计字符出现次数
            maxCount = Math.max(maxCount, freq[s.charAt(r) - 'A']); 

            // 窗口大小 (r - l + 1) - 窗口内最多出现的字符数量 > k 时，需要缩小窗口
            while ((r - l + 1) - maxCount > k) {
                freq[s.charAt(l) - 'A']--;
                l++;
            }

            res = Math.max(res, r - l + 1); // 更新最大窗口大小
        }
        return res;
    }
}
