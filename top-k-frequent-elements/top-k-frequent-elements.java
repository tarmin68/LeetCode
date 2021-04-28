class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap();
        
        for(int i = 0; i < nums.length; i++){
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }
        
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<Pair<Integer,Integer>>((a, b) -> a.getValue() - b.getValue());
        
        for(int key: freq.keySet()){
            pq.add(new Pair(key, freq.get(key)));
            if(pq.size() > k)
                pq.poll();
        }
        
        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = pq.poll().getKey();
        }
        
        return res;
    }
}