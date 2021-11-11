class Solution {
    public int minStartValue(int[] nums) {
        int sum = 0;
        int min = 1;
        
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            min = Math.min(min, sum);
        }
        
        return Math.max(1, 1 - min);
    }
}