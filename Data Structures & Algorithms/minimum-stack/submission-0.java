class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minstack;

    public MinStack() {
        stack = new Stack<>();
        minstack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        // 如果最小栈为空 或者 当前值小于等于最小栈栈顶元素，则将当前值压入最小栈
        if (minstack.isEmpty() || val <= minstack.peek()) {
            minstack.push(val);
        } else {
            // 否则 重复压入最小栈的栈顶元素
            minstack.push(minstack.peek());
        }
    }
    
    public void pop() {
        stack.pop();
        minstack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minstack.peek();
    }
}
