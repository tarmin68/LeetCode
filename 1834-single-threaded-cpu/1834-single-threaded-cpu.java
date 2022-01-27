class Solution {
    public int[] getOrder(int[][] tasks) {
        int[] res = new int[tasks.length];
        Task[] allTasks = new Task[tasks.length];
        
        for(int i = 0; i < tasks.length; i++){
            allTasks[i] = new Task(i, tasks[i][0], tasks[i][1]);
        }
        Arrays.sort(allTasks, (a,b) -> a.enqueueTime - b.enqueueTime);
        
        PriorityQueue<Task> taskQueue = new PriorityQueue();
        int nextAvailableTime = allTasks[0].enqueueTime;
        int idx = 0;
        int resIdx = 0;
        while(idx < allTasks.length){
            while(idx < allTasks.length && allTasks[idx].enqueueTime <= nextAvailableTime){
                taskQueue.add(allTasks[idx++]);
            }
            if(!taskQueue.isEmpty()){
                Task currTask = taskQueue.remove();
                res[resIdx++] = currTask.index;
                nextAvailableTime += currTask.processingTime;
            }
            else if(idx < allTasks.length){
                nextAvailableTime =  allTasks[idx].enqueueTime;
            }
                
        }
        
        while(!taskQueue.isEmpty()){
            Task currTask = taskQueue.remove();
            res[resIdx++] = currTask.index;
            nextAvailableTime = currTask.enqueueTime + currTask.processingTime;
        }
        
        return res;
    }
    
    public class Task implements Comparable<Task>{
        int index;
        int enqueueTime;
        int processingTime;
        
        public Task(int index, int enqueueTime, int processingTime){
            this.index = index;
            this.enqueueTime = enqueueTime;
            this.processingTime = processingTime;
        }
        
        @Override
        public int compareTo(Task t){
            return this.processingTime == t.processingTime ? this.index - t.index : this.processingTime - t.processingTime;
        }
    }
}