class Solution {
    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return res;
        }
        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        back(digits, numString, 0);
        return res;
    }
    StringBuilder temp = new StringBuilder();

    public void back(String digits, String[] numString, int num) {
        if (num == digits.length()) {
            res.add(temp.toString());
            return;
        }
        String str = numString[digits.charAt(num) - '0'];
        for (int i = 0; i < str.length(); i++) {
            temp.append(str.charAt(i));
            back(digits, numString, num + 1);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
