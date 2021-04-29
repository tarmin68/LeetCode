class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(int i = 0; i < tasks.length; i++){
            freq[tasks[i] - 'A']++;
        }
        
        int count = 0;
        int unit = 0;
        while(count < tasks.length){
            PriorityQueue<Pair<Integer, Integer>> q = 
                new PriorityQueue<Pair<Integer,Integer>>((a,b) -> b.getValue() - a.getValue());
        
            for(int i = 0; i < 26; i++){
                if(freq[i] != 0)
                    q.add(new Pair(i, freq[i]));
            }

            for(int i = 0; i <= n && count < tasks.length; i++){
                if(!q.isEmpty()){
                    Pair<Integer, Integer> curr = q.poll();
                    count++;
                    unit++;
                    freq[curr.getKey()]--;
                }
                else{
                    unit++;
                }
            }
        }
        
        return unit;
    }
}