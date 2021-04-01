class NumArray {
    int[] nums;
    SegmentTree ST;

    public NumArray(int[] nums) {
        this.nums = nums;
        
        ST = new SegmentTree(nums.length);
        for(int i = 0; i < nums.length; i++){
            ST.update(1, i + 1, nums[i]);
        }
    }
    
    public void update(int index, int val) {
        int diff = val - nums[index];
        ST.update(1, index + 1, diff);
        nums[index] = val;
    }
    
    public int sumRange(int left, int right) {
        return ST.sumRange(1, left + 1, right + 1);
    }
    
    public class SegmentTree{
        int n;
        int[] lo;
        int[] hi;
        int[] sum;
        
        public SegmentTree(int n){
            lo = new int[4 * n + 1];
            hi = new int[4 * n + 1];
            sum = new int[4 * n + 1];
            
            init(1, 1, n);
        }
        
        public void init(int index, int l, int h){
            lo[index] = l;
            hi[index] = h;
            if(l == h)
                return;
            int mid = (l + h) / 2;
            init(index * 2, l, mid);
            init(index * 2 + 1, mid + 1, h);
        }
        
        public void update(int i, int index, int val){
            if(lo[i] <= index && index <= hi[i]){
                sum[i] += val;
                if(lo[i] < hi[i]){
                    update(i * 2, index, val);
                    update(i * 2 + 1, index, val);
                }
            }
        }
        
        public int sumRange(int index, int left, int right){
            if(hi[index] < left || lo[index] > right)
                return 0;
            if(left <= lo[index] && hi[index] <= right)
                return sum[index];
            return sumRange(index * 2, left, right) + sumRange(index * 2 + 1, left, right);
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */