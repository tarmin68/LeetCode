class Solution {
    int low = 0;
    HashMap<Integer, Integer> rangeMap = new HashMap();
    TreeSet<Integer> rangeSet = new TreeSet();
    Random rand = new Random();

    public Solution(int[] w) {
        for(int i = 0; i < w.length; i++){
            rangeMap.put(low, i);
            rangeSet.add(low);
            low += w[i];
        }
    }
    
    public int pickIndex() {
        int nextInt = rand.nextInt(low);
        int range = rangeSet.floor(nextInt);
        return rangeMap.get(range);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */