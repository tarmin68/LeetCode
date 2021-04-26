class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> diffs = new PriorityQueue();
        
        for(int i = 0; i < heights.length - 1; i++){
            if(heights[i + 1] > heights[i]){
                diffs.add(heights[i + 1] - heights[i]);
                if(diffs.size() > ladders){
                    int minDiff = diffs.poll();
                    if(bricks < minDiff){
                        return i;
                    }
                    bricks -= minDiff;
                }
            }
        }
        
        return heights.length - 1;
    }
}