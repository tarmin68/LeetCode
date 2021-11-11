class Solution {
    public int rob(int[] nums) {
        int[][] maxRobbed = new int[nums.length][2];
        
        maxRobbed[0][0] = 0;
        maxRobbed[0][1] = nums[0];
        
        for(int i = 1; i < nums.length; i++){
            maxRobbed[i][0] = Math.max(maxRobbed[i - 1][1], maxRobbed[i - 1][0]);
            maxRobbed[i][1] = maxRobbed[i - 1][0] + nums[i];
        }
        
        return Math.max(maxRobbed[nums.length - 1][0], maxRobbed[nums.length - 1][1]);
    }
}