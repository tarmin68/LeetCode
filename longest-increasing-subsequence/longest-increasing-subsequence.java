class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] longests = new int[nums.length];
        
        int max = 1;
        longests[0] = 1;
        for(int i = 1; i < nums.length; i++){
            longests[i] = 1;
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    longests[i] = Math.max(longests[i], longests[j] + 1);
                }
            }
            max = Math.max(max, longests[i]);
        }
        
        return max;
    }
}