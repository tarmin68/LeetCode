class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0; 
        int j = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        
        while(i < nums.length && j < nums.length){
            while(j < nums.length && sum < target){
                sum += nums[j++];
            }
            while(sum >= target){
                min = Math.min(min, j - i);
                sum -= nums[i++];
            }
        }
        
        if(min == Integer.MAX_VALUE)
            return 0;
        return min;
    }
}