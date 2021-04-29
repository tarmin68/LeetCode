class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        
        int low = 0;
        int high = nums.length - 1;
        int start = -1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(nums[mid] == target){
                start = mid;
                high = mid - 1;
            }
            if(nums[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        
        if(low == high && nums[low] == target)
            start = low;
        
        low = 0;
        high = nums.length - 1;        
        int end = -1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(nums[mid] == target){
                end = mid;
                low = mid + 1;
            }
            else if(nums[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
                
        res[0] = start;
        res[1] = end;
        return res;
    }
}