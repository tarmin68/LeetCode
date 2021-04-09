class Solution {
    TreeMap<Integer, Integer> tMap = new TreeMap();
    int sum = 0;

    public Solution(int[] w) {
        for(int i = 0; i < w.length; i++){
            sum += w[i];
            tMap.put(sum, i);
        }
    }
    
    public int pickIndex() {
        int rand = (int)(Math.random() * sum);
        int key = tMap.ceilingKey(rand + 1);
        return tMap.get(key);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */