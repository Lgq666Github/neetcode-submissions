public class Solution {
    public boolean checkValidString(String s) {
        // leftMin 表示左括号的最小数量（假设 * 是空字符）
        // leftMax 表示左括号的最大数量（假设 * 是左括号）
        int leftMin = 0, leftMax = 0;

        // 遍历字符串的每一个字符
        for (char c : s.toCharArray()) {
            if (c == '(') {
                // 当前是左括号 '('，需要增加左括号计数
                leftMin++;
                leftMax++;
            } else if (c == ')') {
                // 当前是右括号 ')'，需要减少左括号计数
                leftMin--;
                leftMax--;
            } else {
                // 当前是 '*'，它可以当作空字符、左括号 '(' 或右括号 ')'
                leftMin--;  // 假设 '*' 是右括号 ')'
                leftMax++;  // 假设 '*' 是左括号 '('
            }

            // 如果左括号的最大数量小于零，说明右括号多于左括号，直接返回 false
            if (leftMax < 0) {
                return false;
            }

            // 如果左括号的最小数量小于零，说明 * 被认为是 ')'，调整为零
            if (leftMin < 0) {
                leftMin = 0;
            }
        }

        // 最后检查左括号的最小数量是否为零，表示左右括号配对完成
        return leftMin == 0;
    }
}