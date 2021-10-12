class SparseVector {
    HashMap<Integer, Integer> valueMap = new HashMap();
    
    SparseVector(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0)
                valueMap.put(i, nums[i]);
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int sum = 0;
        for(int idx : this.valueMap.keySet()){
            if(vec.valueMap.keySet().contains(idx)){
                sum += this.valueMap.get(idx) * vec.valueMap.get(idx);
            }
        }
        
        return sum;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);