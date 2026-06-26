class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int j = 0; j < t.length(); j++) {
            table[t.charAt(j) - 'a']--;
        }
        for (int count : table) {
            if (count != 0) return false;
        }
        return true;
    }
}
