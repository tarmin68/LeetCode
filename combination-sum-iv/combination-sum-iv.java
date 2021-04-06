class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] sums = new int[target + 1];
        sums[0] = 1;
        
        for(int i = 1; i <= target; i++){
            int count = 0;
            for(int j = 0; j < nums.length; j++){
                if(i - nums[j] >= 0){
                    count += sums[i - nums[j]];
                }
            }
            sums[i] = count;
        }
        
        return sums[target];
    }
}