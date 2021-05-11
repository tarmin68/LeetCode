class Solution {
    public boolean canPartition(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        
        if(sum % 2 == 1)
            return false;
        
        int halfSum = sum / 2;
        boolean[][] dp = new boolean[nums.length + 1][halfSum + 1];
        dp[0][0] = true;
        for(int i = 1; i < nums.length + 1; i++){
            for(int j = 0; j < halfSum + 1; j++){
                dp[i][j] |= dp[i - 1][j];
                if(j - nums[i - 1] >= 0)
                    dp[i][j] |= dp[i - 1][j - nums[i - 1]];
            }
        }
        
        return dp[nums.length][halfSum];
    }
}