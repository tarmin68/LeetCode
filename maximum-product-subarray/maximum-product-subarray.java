class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            int prod = nums[i];
            max = Math.max(max, prod);
            if(nums[i] == 0)
                continue;
            for(int j = i + 1; j < nums.length; j++){
                prod *= nums[j];
                max = Math.max(max, prod);
                if(nums[j] == 0)
                    break;
            }
        }
        
        return max;
    }
}