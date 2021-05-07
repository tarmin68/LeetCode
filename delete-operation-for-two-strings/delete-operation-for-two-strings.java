class Solution {
    HashMap<Pair<Integer, Integer>, Integer> myMap = new HashMap();
    
    public int minDistance(String word1, String word2) {
        int maxSub = maxSubstring(word1, word2, 0, 0);
        
        return word1.length() + word2.length() - (2 * maxSub);
    }
    
    public int maxSubstring(String word1, String word2, int idx1, int idx2){
        if(idx1 >= word1.length() || idx2 >= word2.length())
            return 0;
        if(myMap.get(new Pair(idx1, idx2)) != null)
            return myMap.get(new Pair(idx1, idx2));
        
        if(word1.charAt(idx1) == word2.charAt(idx2)){
            int max = 1 + maxSubstring(word1, word2, idx1 + 1, idx2 + 1);
            myMap.put(new Pair(idx1, idx2), max);
            return max;
        }
        else{
            int max1 = maxSubstring(word1, word2, idx1 + 1, idx2);
            int max2 = maxSubstring(word1, word2, idx1, idx2 + 1);
            myMap.put(new Pair(idx1, idx2), Math.max(max1, max2));
            return Math.max(max1, max2);
        }
    }
}