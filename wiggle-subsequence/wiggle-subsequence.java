class Solution {
    int[][] dp;
    
    public int wiggleMaxLength(int[] nums) {
        dp = new int[2][nums.length];
        Arrays.fill(dp[0], -1);
        Arrays.fill(dp[1], -1);
        
        int max = 0;
        max = Math.max(max, getMax(nums, 0, true));
        max = Math.max(max, getMax(nums, 0, false));
        
        return max;
    }
    
    public int getMax(int[] nums, int i, boolean wasPositive){
        if(wasPositive && dp[1][i] != -1) return dp[1][i];
        if(!wasPositive && dp[0][i] != - 1) return dp[0][i];
        
        int max = 0;
        for(int j = i + 1; j < nums.length; j++){
            if(wasPositive && nums[j] - nums[i] < 0){
                max = Math.max(max, getMax(nums, j, false));
            }
            else if(!wasPositive && nums[j] - nums[i] > 0){
                max = Math.max(max, getMax(nums, j, true));
            }
        }
        
        if(wasPositive) dp[1][i] = max + 1;
        if(!wasPositive) dp[0][i] = max + 1;
        return max + 1;
    }
}