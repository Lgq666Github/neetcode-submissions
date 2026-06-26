class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] mix = new int[26];
        for (int i = 0; i < s.length(); i++) {
            mix[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            mix[t.charAt(i) - 'a']--;
        }
        for (int count : mix) {
            if (count != 0) return false;
        }
        return true;
    }
}
