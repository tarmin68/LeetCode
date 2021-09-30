class MyQueue {
    Stack<Integer> first;
    Stack<Integer> second;

    public MyQueue() {
        first = new Stack();
        second = new Stack();
    }
    
    public void push(int x) {
        if(second.isEmpty())
            first.push(x);
        else{
            while(!second.isEmpty()){
                first.push(second.pop());
            }
            first.push(x);
        }
    }
    
    public int pop() {
        if(first.isEmpty()){
            return second.pop();
        }
        else{
            while(!first.isEmpty()){
                second.push(first.pop());
            }
            return second.pop();
        }
    }
    
    public int peek() {
        if(first.isEmpty()){
            return second.peek();
        }
        else{
            while(!first.isEmpty()){
                second.push(first.pop());
            }
            return second.peek();
        }
    }
    
    public boolean empty() {
        return first.isEmpty() && second.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */