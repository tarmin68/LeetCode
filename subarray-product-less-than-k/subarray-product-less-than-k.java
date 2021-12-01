class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        int product = nums[0];
        
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            while(j < nums.length && product < k){
                count += (j - i + 1);
                j++;
                if(j == nums.length)
                    break;
                product *= nums[j];
            }
            product /= nums[i];
        }
        
        return count;
    }
}