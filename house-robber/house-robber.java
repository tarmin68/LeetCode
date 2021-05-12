class Solution {
    Integer[][] allMax;
    public int rob(int[] nums) {
        allMax = new Integer[nums.length][2];
        return getMax(nums, 0, 0);
    }
    
    public int getMax(int[] nums, int idx, int preRobbed){
        if(idx >= nums.length)
            return 0;
        
        if(allMax[idx][preRobbed] != null)
            return allMax[idx][preRobbed];
        
        if(preRobbed == 1){
            int max = getMax(nums, idx + 1, 0);
            allMax[idx][1] = max;
            return max;
        }
        else{
            int max = Math.max(getMax(nums, idx + 1, 1) + nums[idx], getMax(nums, idx + 1, 0));
            allMax[idx][0] = max;
            return max;
        }
    }
}