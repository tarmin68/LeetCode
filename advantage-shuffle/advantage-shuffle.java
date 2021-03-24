class Solution {
    public int[] advantageCount(int[] A, int[] B) {
        PriorityQueue<Pair<Integer, Integer>> Bq = new PriorityQueue<>((a,b) -> Integer.compare(b.getKey(), a.getKey()));
        PriorityQueue<Integer> Aq = new PriorityQueue<>(Collections.reverseOrder());
        
        boolean[] isFilled = new boolean[A.length];
        
        for(int i = 0; i < A.length; i++){
            Aq.add(A[i]);
        }
        for(int i = 0; i < B.length; i++){
            Bq.add(new Pair(B[i], i));
        }
        
        int[] res = new int[A.length];
        while(!Bq.isEmpty()){
            Pair<Integer, Integer> currMax = Bq.poll();
            if(Aq.peek() > currMax.getKey()){
                res[currMax.getValue()] = Aq.poll();
                isFilled[currMax.getValue()] = true;
            }
        }
        
        for(int i = 0; i < A.length; i++){
            if(!isFilled[i]){
                res[i] = Aq.poll();
            } 
        }
        
        return res;
    }
}