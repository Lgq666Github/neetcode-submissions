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
                return false;
            } else {
                q.pop();
            }
        }
        return q.isEmpty();
    }
}
