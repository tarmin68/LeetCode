class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        
        while(l < r){
            int mid = (r - l) / 2 + l;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < target)
                l = mid + 1;
            else
                r = mid;
        }
        
        if(l == 0 && target < nums[0])
            return 0;
        if(l == nums.length - 1 && target > nums[nums.length - 1])
            return l + 1;
        return l;
    }
}