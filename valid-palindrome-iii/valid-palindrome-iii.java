class Solution {
    HashMap<Pair<Integer, Integer>, Integer> countMap = new HashMap();
    
    public boolean isValidPalindrome(String s, int k) {
        return getCount(s, 0, s.length() - 1) <= k;
    }
    
    public int getCount(String s, int i, int j){
        if(i < 0 || j > s.length() - 1 || i >= j) return 0;
        
        if(countMap.get(new Pair(i, j)) != null)
            return countMap.get(new Pair(i, j));
                                
        if(s.charAt(i) == s.charAt(j)){
            int count = getCount(s, i + 1, j - 1);
            countMap.put(new Pair(i, j), count);
            return count;
        }
        
        int count1 = getCount(s, i + 1, j) + 1;
        int count2 = getCount(s, i, j - 1) + 1;
        int count = Math.min(count1, count2);
        countMap.put(new Pair(i, j), count);
        return count;                        
    }
}