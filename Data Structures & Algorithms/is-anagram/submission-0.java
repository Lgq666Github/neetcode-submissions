class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] word = new int[26];
        for (int i = 0; i < s.length(); i++) {
            word[s.charAt(i) - 'a']++;
        }
        for (int j = 0; j < t.length(); j++) {
            word[t.charAt(j) - 'a']--;
        }
        for (int count : word) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}
