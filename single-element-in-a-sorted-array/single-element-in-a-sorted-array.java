class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        
        int l = 0;
        int h = nums.length - 1;
        
        while(l <= h){
            int mid = (l + h)/2;
            if(mid == 0 && nums[mid] != nums[mid + 1])
                return nums[mid];
            else if(mid == nums.length - 1 && nums[mid] != nums[mid - 1])
                return nums[mid];
            else if(nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1])
                return nums[mid];
            
            if(mid % 2 == 0){
                if(mid > 0 && nums[mid] == nums[mid - 1])
                    h = mid - 2;
                else
                    l = mid + 2;
            }
            else{
                if(mid < nums.length - 1 && nums[mid] == nums[mid + 1])
                    h = mid - 1;
                else
                    l = mid + 1;
            }
        }
        
        return -1;
    }
}