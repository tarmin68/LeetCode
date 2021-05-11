class Solution {
//     public boolean canJump(int[] nums) {
//         boolean[] reachable = new boolean[nums.length];
        
//         reachable[nums.length - 1] = true;
        
//         for(int i = nums.length - 2; i >= 0; i--){
//             for(int j = nums[i]; j >= 0; j--){
//                 if(i + j < nums.length)
//                     reachable[i] = reachable[i] || reachable[i + j];
//                 if(reachable[i])
//                     break;
//             }
//         }
        
//         return reachable[0];
//     }
    
    public boolean canJump(int[] nums) {
        int maxReach = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(i <= maxReach)
                maxReach = Math.max(maxReach, i + nums[i]);
            else
                return false;
        }
        
        return true;
    }
}