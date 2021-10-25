class MinStack {
    Deque<Integer> mainStack;
    Deque<Integer> minStack;

    public MinStack() {
        mainStack = new LinkedList();
        minStack = new LinkedList();
    }
    
    public void push(int val) {
        if(mainStack.isEmpty()){
            minStack.push(val);
        }
        else{
            minStack.push(Math.min(val, minStack.peek()));
        }
        mainStack.push(val);
    }
    
    public void pop() {
        mainStack.pop();
        minStack.pop();
    }
    
    public int top() {
        return mainStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */