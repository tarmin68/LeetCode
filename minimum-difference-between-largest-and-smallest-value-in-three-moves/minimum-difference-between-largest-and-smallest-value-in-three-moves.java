class Solution {
    public int minDifference(int[] nums) {
        if(nums.length <= 3)
            return 0;
        
        PriorityQueue<Integer> increasing = new PriorityQueue();
        PriorityQueue<Integer> decreasing = new PriorityQueue(Collections.reverseOrder());
        
        for(int i = 0; i < nums.length; i++){
            increasing.add(nums[i]);
            decreasing.add(nums[i]);
        }
        
        int[] maxes = new int[4];
        for(int i = 0; i < 4; i++){
            maxes[i] = decreasing.poll();
        }
        
        int[] mins = new int[4];
        for(int i = 0; i < 4; i++){
            mins[i] = increasing.poll();
        }
        
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < 4; i++){
            min = Math.min(min, maxes[3 - i] - mins[i]);
        }
        return min;
    }
}