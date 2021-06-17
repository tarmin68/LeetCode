class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int start = -1;
        int lastIdx = -1;
        int count = 0;
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] >= left && nums[i] <= right)
                lastIdx = i;
            else if(nums[i] > right){
                start = i;
                lastIdx = i;
            }
            count += (lastIdx - start);
        }
        
        return count;
    }
}