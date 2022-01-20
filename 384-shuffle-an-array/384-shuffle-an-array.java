class Solution {
    int[] nums;

    public Solution(int[] nums) {
        this.nums = nums;
    }
    
    public int[] reset() {
        return nums;
    }
    
    public int[] shuffle() {
        int[] res = new int[nums.length];
        Set<Integer> used = new HashSet();
        
        Random rand = new Random();
        for(int i = 0; i < nums.length; i++){
            int idx = rand.nextInt(nums.length);
            while(used.contains(idx))
                idx = rand.nextInt(nums.length);
            res[i] = nums[idx];
            used.add(idx);
        }
        
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */