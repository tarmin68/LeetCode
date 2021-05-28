class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> numSet = new HashSet();
        int start = 0;
        int end = 0;
        int sum = 0;
        int maxSum = 0;
        
        while(end < nums.length){
            while(numSet.contains(nums[end])){
                sum -= nums[start];
                numSet.remove(nums[start]);
                start++;
            }
            sum += nums[end];
            numSet.add(nums[end]);
            end++;
            maxSum = Math.max(maxSum, sum);
        }
        
        return maxSum;
    }
}