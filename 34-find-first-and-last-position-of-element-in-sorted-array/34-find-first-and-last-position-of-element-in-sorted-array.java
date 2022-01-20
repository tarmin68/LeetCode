class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = findFirst(nums, target);
        res[1] = findLast(nums, target);
        
        return res;
    }
    
    public int findFirst(int[] nums, int target){
        int l = 0;
        int h = nums.length - 1;
        
        int ans = -1;
        while(l <= h){
            int mid = (l + h) / 2;
            if(nums[mid] == target){
                ans = mid;
                h = mid - 1;
            }
            else if(nums[mid] > target)
                h = mid - 1;
            else
                l = mid + 1;
        }
        
        return ans;
    }
    
    public int findLast(int[] nums, int target){
        int l = 0;
        int h = nums.length - 1;
        
        int ans = -1;
        while(l <= h){
            int mid = (l + h) / 2;
            if(nums[mid] == target){
                ans = mid;
                l = mid + 1;
            }
            else if(nums[mid] > target)
                h = mid - 1;
            else
                l = mid + 1;
        }
        
        return ans;
    }
}