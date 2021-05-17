class Solution {
    HashMap<Pair<Integer, Integer>, Integer> minMaps = new HashMap();
    public int minDistance(String word1, String word2) {
        return getMin(word1, word2, 0, 0);
    }
    
    public int getMin(String word1, String word2, int idx1, int idx2){
        if(idx1 == word1.length()){
            return word2.length() - idx2;
        }
        if(idx2 == word2.length()){
            return word1.length() - idx1;
        }
        if(minMaps.get(new Pair(idx1, idx2)) != null)
            return minMaps.get(new Pair(idx1, idx2));
        
        if(word1.charAt(idx1) == word2.charAt(idx2)){
            int min = getMin(word1, word2, idx1 + 1, idx2 + 1);
            minMaps.put(new Pair(idx1, idx2), min);
            return min;
        }
        
        int min1 = 1 + getMin(word1, word2, idx1, idx2 + 1);
        int min2 = 1 + getMin(word1, word2, idx1 + 1, idx2);
        int min3 = 1 + getMin(word1, word2, idx1 + 1, idx2 + 1);
        int min = Math.min(min1, min2);
        min = Math.min(min, min3);
        minMaps.put(new Pair(idx1, idx2), min);
        return min;
    }
}