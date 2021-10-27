class Solution {
    public void sortColors(int[] nums) {
        int zeroIdx = 0;
        int twoIdx = nums.length - 1;
        int idx = 0;
        
        while(idx <= twoIdx){
            if(nums[idx] == 0){
                int temp = nums[zeroIdx];
                nums[zeroIdx++] = nums[idx];
                nums[idx++] = temp;
            }
            else if(nums[idx] == 2){
                int temp = nums[twoIdx];
                nums[twoIdx--] = nums[idx];
                nums[idx] = temp;
            }
            else{
                idx++;
            }
        }
    }
}