class MedianFinder {
    ArrayList<Integer> nums;
    /** initialize your data structure here. */
    public MedianFinder() {
        nums = new ArrayList();
    }
    
    public void addNum(int num) {
        nums.add(num);
    }
    
    public double findMedian() {
        Collections.sort(nums);
        if(nums.size() % 2 == 1){
            return nums.get(nums.size() / 2);
        }
        else{
            return (nums.get(nums.size() / 2) + nums.get(nums.size() / 2 - 1)) / 2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */