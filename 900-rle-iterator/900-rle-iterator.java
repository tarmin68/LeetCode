class RLEIterator {
    int[] encoding;
    ArrayList<Long> counts = new ArrayList();
    ArrayList<Integer> nums = new ArrayList();
    long total = 0;
    long target = 0;

    public RLEIterator(int[] encoding) {
        this.encoding = encoding;
        
        long count = 0;
        for(int i = 0; i < encoding.length; i += 2){
            if(encoding[i] != 0){
                count += encoding[i];
                counts.add(count);
                nums.add(encoding[i + 1]);
            }
        }
        total = count;
    }
    
    public int next(int n) {
        target += n;
        if(target > total)
            return -1;
        
        return nums.get(find(target));
    }
    
    public int find(long target){
        int lo = 0;
        int hi = counts.size() - 1;
        
        int ans = 0;
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            if(counts.get(mid) == target)
                return mid;
            else if(counts.get(mid) < target){
                lo = mid + 1;
            }
            else{
                ans = mid;
                hi = mid - 1;
            }
        }
        
        return ans;
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(encoding);
 * int param_1 = obj.next(n);
 */