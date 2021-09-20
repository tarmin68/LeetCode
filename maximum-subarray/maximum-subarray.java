class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int[] sums = new int[nums.length];
        
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; i + j < nums.length; j++){
                sums[j] += nums[j + i];
                maxSum = Math.max(maxSum, sums[j]);
            }
        }
        
        return maxSum;
    }
    
}