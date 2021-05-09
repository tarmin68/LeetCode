class Solution {
    public boolean isPossible(int[] target) {
        int sum = 0;
        PriorityQueue<Integer> q = new PriorityQueue(Collections.reverseOrder());
        
        if(target.length == 1)
            return target[0] == 1;
        
        for(int i = 0; i < target.length; i++){
            sum += target[i];
            q.add(target[i]);
        }
        
        while(q.peek() != 1){
            int currMax = q.poll();
            int remain = sum - currMax;
            if(remain == 1)
                return true;
            if(currMax % remain == 0 || currMax % remain == currMax)
                return false;
            q.add(currMax % remain);
            sum = sum - currMax + (currMax % remain);
        }
        
        return true;
    }
}