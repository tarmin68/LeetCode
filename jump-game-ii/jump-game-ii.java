class Solution {
    public int jump(int[] nums) {
        int[] res = new int[nums.length];
        
        Arrays.fill(res, Integer.MAX_VALUE);
        res[nums.length - 1] = 0;
        
        for(int i = nums.length - 2; i >= 0; i--){
            for(int j = 1; j <= nums[i]; j++){
                if(i + j < nums.length && res[i + j] != Integer.MAX_VALUE){
                    res[i] = Math.min(res[i], res[i + j] + 1);
                }
            }
        }
        
        return res[0];
    }
}