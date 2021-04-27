class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        
        PriorityQueue<Integer> q = new PriorityQueue();
        q.add(intervals[0][1]);
        int max = 1;
        for(int i = 1; i < intervals.length; i++){
            if(q.peek() <= intervals[i][0]){
                q.poll();
                q.add(intervals[i][1]);
            }
            else{
                q.add(intervals[i][1]);
                max = Math.max(max, q.size());
            }
        }
        
        return max;
    }
    
}