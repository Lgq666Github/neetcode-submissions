class Solution {
    public boolean isValid(String s) {
        Deque<Character> q = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                q.push(')');
            } else if (ch == '{') {
                q.push('}');
            } else if (ch == '[') {
                q.push(']');
            } else if (q.isEmpty() || q.peek() != ch) {
                return false; // 栈为空 或者 栈顶元素不匹配，返回 false
            } else {
                q.pop(); // 栈顶匹配，弹出
            }
        }
        return q.isEmpty(); // 栈为空则表示全部匹配
    }
}
