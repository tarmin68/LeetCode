class MyCircularQueue {
    int[] nums;
    int size;
    int front;
    int rear;
    int k;

    public MyCircularQueue(int k) {
        this.nums = new int[k];
        this.size = 0;
        this.front = 0;
        this.rear = -1;
        this.k = k;
    }
    
    public boolean enQueue(int value) {
        if(isFull())
            return false;
        if(++rear == k)
            rear = 0;
        nums[rear] = value;
        size++;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty())
            return false;
        if(++front == k)
            front = 0;
        size--;
        return true;
    }
    
    public int Front() {
        if(isEmpty())
            return -1;
        else
            return nums[front];
    }
    
    public int Rear() {
        if(isEmpty())
            return -1;
        else
            return nums[rear];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == k;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */