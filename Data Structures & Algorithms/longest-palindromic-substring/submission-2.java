class Solution {
    public String longestPalindrome(String s) {
        int start = 0, maxLen = 0;
        for (int c = 0; c < s.length(); c++) {
            int len1 = expand(s, c, c); // 奇数 s[c]为中心
            int len2 = expand(s, c, c + 1); // 偶数 s[c]和s[c+1]为中心
            int len = Math.max(len1, len2);
            if (len > maxLen) {
                maxLen = len;
                start = c - (len - 1) / 2;
            }
        }
        return s.substring(start, start + maxLen);
    }

    private int expand(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }
}
