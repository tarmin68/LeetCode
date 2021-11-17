class Solution {
    public int findMin(int[] nums) {
        if(nums[0] <= nums[nums.length - 1])
            return nums[0];
        
        int l = 0;
        int h = nums.length - 1;
        
        while(l <= h){
            int mid = (l + h) / 2;
            
            if(mid > 0 && nums[mid] < nums[mid - 1])
                return nums[mid];
            
            if(nums[h] < nums[mid])
                l = mid + 1;
            else
                h = mid - 1;
        }
        
        return -1;
    }
}