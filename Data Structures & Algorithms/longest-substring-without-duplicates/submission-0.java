class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> charset = new HashSet<>();
        int l = 0, res = 0;
        for (int r = 0; r < s.length(); r++) {
            while (charset.contains(s.charAt(r))) {
                charset.remove(s.charAt(l));
                l++;
            }
            charset.add(s.charAt(r));
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
