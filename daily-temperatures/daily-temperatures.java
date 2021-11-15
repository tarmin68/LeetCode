class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        ArrayDeque<Pair<Integer, Integer>> s = new ArrayDeque();
        
        for(int i = n - 1; i >= 0; i--){
            while(!s.isEmpty() && s.peek().getKey() <= temperatures[i])
                    s.poll();
            if(!s.isEmpty())
                res[i] = s.peek().getValue() - i;
            s.push(new Pair<Integer,Integer>(temperatures[i], i));
        }
        
        return res;
    }
}