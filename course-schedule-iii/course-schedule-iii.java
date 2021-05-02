class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a,b) -> a[1]-b[1]);
        
        PriorityQueue<Integer> q = new PriorityQueue(Collections.reverseOrder());
        int time = 0;
        for(int i = 0; i < courses.length; i++){
            if(time + courses[i][0] <= courses[i][1]){
                q.add(courses[i][0]);
                time += courses[i][0];
            }
            else if(!q.isEmpty() && q.peek() > courses[i][0]){
                int prevDur = q.poll();
                q.add(courses[i][0]);
                time -= (prevDur - courses[i][0]);
            }
        }
        
        return q.size();
    }
}